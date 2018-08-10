package pl.recrutimentTask.pointOfSale;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.recruitmentTask.devices.BarcodeScanner;
import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.InputDevice;
import pl.recruitmentTask.devices.LiquidCrystalDisplay;
import pl.recruitmentTask.devices.Printer;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.database.SmallItem;
import pl.recrutimentTask.database.SmallItemsDatabase;
import pl.recrutimentTask.database.databaseSearcher.DatabasesSearcher;
import pl.recrutimentTask.observers.ScannerObserver;
import pl.recrutimentTask.validationChain.OutputLink;
import pl.recrutimentTask.validationChain.PrintEmptyCodeLink;
import pl.recrutimentTask.validationChain.PrintExitLink;
import pl.recrutimentTask.validationChain.PrintNameLink;
import pl.recrutimentTask.validationChain.PrintNotFoundLink;

public class PointOfSaleTest {
	
	private static PointOfSale pointOfSale = new PointOfSale();
	private static InputDevice scanner = new BarcodeScanner();
	@BeforeClass
	public static void setUp(){
		SmallItemsDatabase firstDB = new SmallItemsDatabase();
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','a'}, 3.0f, "aa"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','b'}, 4.0f, "ab"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','c'}, 5.0f, "ac"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','d'}, 6.0f, "ad"));
		
		SmallItemsDatabase secondDB = new SmallItemsDatabase();
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','a'}, 3.0f, "ba"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','b'}, 3.0f, "bb"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','c'}, 3.0f, "bc"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','d'}, 3.0f, "bd"));
		
		DatabasesSearcher dbSearcher = new DatabasesSearcher();
		dbSearcher.addNewDatabase(firstDB);
		dbSearcher.addNewDatabase(secondDB);
		
		TextOutputDevice printer = new Printer();
		TextOutputDevice lcd = new LiquidCrystalDisplay();
		
		pointOfSale.addOutputDevice(DeviceNames.LCD, lcd);
		pointOfSale.addOutputDevice(DeviceNames.PRINTER, printer);
		pointOfSale.setDbSearcher(dbSearcher);
		
		new ScannerObserver(pointOfSale, scanner);
		
		OutputLink empty = new PrintEmptyCodeLink(pointOfSale);
		OutputLink exit = new PrintExitLink(pointOfSale);
		OutputLink name = new PrintNameLink(pointOfSale);
		OutputLink notFound = new PrintNotFoundLink(pointOfSale);
		empty.setNextLink(exit);
		exit.setNextLink(name);
		name.setNextLink(notFound);
		pointOfSale.setRootLink(empty);
		
	}
	
	@Test
	public void scanTest(){
		PrintStream originalOut = System.out;
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		scanner.setCurrentInput(new char[]{'a','a','a','d'});
		scanner.setCurrentInput(new char[]{'a','a','a','c'});
		scanner.setCurrentInput(new char[]{'a','a','a','a'});
		scanner.setCurrentInput(new char[]{'a','a','a','f'});
		scanner.setCurrentInput(new char[]{'e','x','i','t'});
		
		
		System.setOut(originalOut);
		
		StringBuilder sb = new StringBuilder();
		sb.append("ad 6.0").append(System.getProperty("line.separator"));
		sb.append("ac 5.0").append(System.getProperty("line.separator"));
		sb.append("aa 3.0").append(System.getProperty("line.separator"));
		sb.append("Product not found").append(System.getProperty("line.separator"));
		sb.append("ad 6.0").append(System.getProperty("line.separator"));
		sb.append("ac 5.0").append(System.getProperty("line.separator"));
		sb.append("aa 3.0").append(System.getProperty("line.separator"));
		sb.append("14.0").append(System.getProperty("line.separator"));
		String expectedOut = sb.toString();
		String givenOut = outputStream.toString();

		assertEquals(expectedOut,givenOut);
		
	}
	
}
