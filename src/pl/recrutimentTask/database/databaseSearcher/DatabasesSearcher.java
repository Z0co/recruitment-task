package pl.recrutimentTask.database.databaseSearcher;

import java.util.HashSet;
import java.util.Optional;

import pl.recrutimentTask.database.DatabaseItem;
import pl.recrutimentTask.database.ItemsDatabase;

public class DatabasesSearcher {
	private HashSet<ItemsDatabase> databases = new HashSet<ItemsDatabase>();
	
	public void addNewDatabase(ItemsDatabase database){
		databases.add(database);
	}
	
	public Optional<DatabaseItem> searchForItem(char[] barcode){
		for(ItemsDatabase database : databases){
			Optional<DatabaseItem> item = database.getItem(barcode);
			if(item.isPresent()){
				return item;
			}
		}
		return Optional.empty();
	}
}
