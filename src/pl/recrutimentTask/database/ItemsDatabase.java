package pl.recrutimentTask.database;

import java.util.Optional;

public interface ItemsDatabase {
	public Optional<DatabaseItem> getItem(char[] itemBarcode);
	public void addItem(DatabaseItem item);
}
