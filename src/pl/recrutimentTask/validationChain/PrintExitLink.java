package pl.recrutimentTask.validationChain;

import java.util.Arrays;
import java.util.List;

import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.database.DatabaseItem;
import pl.recrutimentTask.pointOfSale.PointOfSale;
import pl.recrutimentTask.pointOfSale.bill.Bill;

public class PrintExitLink implements OutputLink,NameAndPricePrinterLink{
	final private char[] EXIT = {'e','x','i','t'};
	private PointOfSale pointOfSale;
	private OutputLink nextLink;
	
	public PrintExitLink(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}
	
	@Override
	public void print(char[] input) {
		if(Arrays.equals(EXIT, input)){
			printEachItem();
		}
		else if(nextLink!=null){
			nextLink.print(input);
		}
	}

	public void printEachItem(){
		TextOutputDevice device = getOutputDevice();
		Bill scannedBill = pointOfSale.getScannedBill();
		List<DatabaseItem> items = scannedBill.getItems();
		for(DatabaseItem item : items){
			String output = getOutputText(item);
			device.output(output);
		}
		device.output(Float.toString(scannedBill.getSummedPrice()));
	}
	
	@Override
	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	@Override
	public void setNextLink(OutputLink nextLink) {
		this.nextLink = nextLink;
		
	}

	@Override
	public TextOutputDevice getOutputDevice() {
		return pointOfSale.getOutputDevice(DeviceNames.PRINTER);
	}
	
}
