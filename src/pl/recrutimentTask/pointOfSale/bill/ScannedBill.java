package pl.recrutimentTask.pointOfSale.bill;

import java.util.ArrayList;
import java.util.List;

import pl.recrutimentTask.database.DatabaseItem;

public class ScannedBill implements Bill{

	List<DatabaseItem> items = new ArrayList<DatabaseItem>();
	
	
	@Override
	public List<DatabaseItem> getItems() {
		return items;
	}

	@Override
	public float getSummedPrice() {
		double sum = 0;
		sum = items.stream().mapToDouble(item -> item.getItemPrice()).sum();
		return (float) sum;
	}

	@Override
	public void addItem(DatabaseItem item) {
		items.add(item);
	}

}
