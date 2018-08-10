package pl.recrutimentTask.pointOfSale;

import java.util.HashMap;

import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.InputDevice;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.database.databaseSearcher.DatabasesSearcher;
import pl.recrutimentTask.observers.InformedObject;
import pl.recrutimentTask.pointOfSale.bill.Bill;
import pl.recrutimentTask.pointOfSale.bill.ScannedBill;
import pl.recrutimentTask.validationChain.OutputLink;

public class PointOfSale implements InformedObject{

	private DatabasesSearcher dbSearcher;
	private OutputLink rootLink;
	private HashMap<DeviceNames, TextOutputDevice> outputDevices = new HashMap<DeviceNames, TextOutputDevice>();
	private Bill scannedBill = new ScannedBill();
	
	
	public Bill getScannedBill() {
		return scannedBill;
	}

	public void addOutputDevice(DeviceNames lcd,TextOutputDevice device){
		outputDevices.put(lcd, device);
	}
	
	public TextOutputDevice getOutputDevice(DeviceNames name){
		return outputDevices.get(name);
	}
	
	public DatabasesSearcher getDbSearcher() {
		return dbSearcher;
	}

	public void setDbSearcher(DatabasesSearcher dbSearcher) {
		this.dbSearcher = dbSearcher;
	}

	public void setRootLink(OutputLink rootLink) {
		this.rootLink = rootLink;
	}


	@Override
	public void getInformation(InputDevice device) {
		char[] input = device.getInput();
		rootLink.print(input);
	}
	
	
}
