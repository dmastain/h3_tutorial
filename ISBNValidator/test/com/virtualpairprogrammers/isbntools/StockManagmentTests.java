package com.virtualpairprogrammers.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockManagmentTests {

	@Test
	public void test_can_get_a_correct_locator_code() {
		ExternalISBNDataService testService = new ExternalISBNDataService() {
			
			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
			}
		};
		

		StockManager stockManager = new StockManager();
		stockManager.setService(testService);
		
		String isbn = "0140177396";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("7396J4", locatorCode);
	}

}
