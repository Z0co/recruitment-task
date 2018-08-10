package pl.recrutimentTask.validationChain;

import java.util.Optional;

import pl.recruitmentTask.devices.DeviceNames;
import pl.recruitmentTask.devices.TextOutputDevice;
import pl.recrutimentTask.database.DatabaseItem;
import pl.recrutimentTask.database.databaseSearcher.DatabasesSearcher;
import pl.recrutimentTask.pointOfSale.PointOfSale;
import pl.recrutimentTask.pointOfSale.bill.Bill;

public class PrintNameLink implements OutputLink,NameAndPricePrinterLink{
	private PointOfSale pointOfSale;
	private OutputLink nextLink;
	
	public PrintNameLink(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}
	
	@Override
	public void print(char[] input) {
		Optional<DatabaseItem> item = searchForItem(input);
		if(item.isPresent()){
			DatabaseItem dbItem = item.get();
			addItemToBill(dbItem);
			String output = getOutputText(item.get());
			TextOutputDevice device = getOutputDevice();
			device.output(output);
		}
		else if(nextLink!=null){
			nextLink.print(input);
		}
	}

	private void addItemToBill(DatabaseItem item){
		Bill bill = pointOfSale.getScannedBill();
		bill.addItem(item);
	}
	
	private Optional<DatabaseItem> searchForItem(char[] input){
		DatabasesSearcher dbSearcher = pointOfSale.getDbSearcher();
		Optional<DatabaseItem> item = dbSearcher.searchForItem(input);
		return item;
	}
	
	@Override
	public void setNextLink(OutputLink nextLink) {
		this.nextLink = nextLink;
	}

	@Override
	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	@Override
	public TextOutputDevice getOutputDevice() {
		return pointOfSale.getOutputDevice(DeviceNames.LCD);
	}

}
