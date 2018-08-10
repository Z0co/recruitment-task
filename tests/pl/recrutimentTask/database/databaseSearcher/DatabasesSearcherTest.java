package pl.recrutimentTask.database.databaseSearcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.recrutimentTask.database.SmallItem;
import pl.recrutimentTask.database.SmallItemsDatabase;

public class DatabasesSearcherTest {
	
	public static DatabasesSearcher dbSearcher = new DatabasesSearcher();
	@BeforeClass
	public static void prepareDatabases(){
		SmallItemsDatabase firstDB = new SmallItemsDatabase();
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','a'}, 3.0f, "aa"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','b'}, 4.0f, "ab"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','c'}, 5.0f, "ac"));
		firstDB.addItem(new SmallItem(new char[]{'a','a','a','d'}, 6.0f, "ad"));
		
		SmallItemsDatabase secondDB = new SmallItemsDatabase();
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','a'}, 3.0f, "ba"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','b'}, 3.0f, "ba"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','c'}, 3.0f, "ba"));
		secondDB.addItem(new SmallItem(new char[]{'b','b','b','d'}, 3.0f, "ba"));
			
		dbSearcher.addNewDatabase(firstDB);
		dbSearcher.addNewDatabase(secondDB);
	}
	
	@Test
	public void searchForItemTest(){
		assertTrue(dbSearcher.searchForItem(new char[]{'b','b','b','a'}).isPresent());
		assertFalse(dbSearcher.searchForItem(new char[]{'b','b','b','h'}).isPresent());
		assertFalse(dbSearcher.searchForItem(null).isPresent());
	}
}
