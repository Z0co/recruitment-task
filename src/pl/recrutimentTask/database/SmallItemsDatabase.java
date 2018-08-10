package pl.recrutimentTask.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SmallItemsDatabase implements ItemsDatabase{
	
	private ArrayList<DatabaseItem> items = new ArrayList<DatabaseItem>();
	
	@Override
	public Optional<DatabaseItem> getItem(char[] itemBarcode) {
		Optional<DatabaseItem> item = items.stream().
				filter(itm -> Arrays.equals(itm.getItemBarCode(),itemBarcode)).
				findFirst(); 
		
		return item;
	}

	@Override
	public void addItem(DatabaseItem item) {
		items.add(item);
	}

}
