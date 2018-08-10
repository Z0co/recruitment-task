package pl.recrutimentTask.database;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SmallItemDatabaseTest {

	ItemsDatabase smallItemsDatabase = new SmallItemsDatabase();
	
	@Before
	public void setUp(){
		smallItemsDatabase.addItem(new SmallItem(new char[]{'b','b','b','a'}, 3.0f, "ba"));
		smallItemsDatabase.addItem(new SmallItem(new char[]{'b','b','b','b'}, 3.0f, "bb"));
		smallItemsDatabase.addItem(new SmallItem(new char[]{'b','b','b','c'}, 3.0f, "bc"));
		smallItemsDatabase.addItem(new SmallItem(new char[]{'b','b','b','d'}, 3.0f, "bd"));
	}
	
	@Test
	public void testSearchItem(){
		assertTrue(smallItemsDatabase.getItem(new char[]{'b','b','b','b'}).isPresent());
		assertTrue(smallItemsDatabase.getItem(new char[]{'b','b','b','d'}).isPresent());
		assertFalse(smallItemsDatabase.getItem(new char[]{'b','b','b','f'}).isPresent());
	}
}
