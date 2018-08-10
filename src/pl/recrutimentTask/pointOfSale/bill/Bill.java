package pl.recrutimentTask.pointOfSale.bill;

import java.util.List;

import pl.recrutimentTask.database.DatabaseItem;

public interface Bill {
	public List<DatabaseItem> getItems();
	public float getSummedPrice();
	public void addItem(DatabaseItem item);
}
