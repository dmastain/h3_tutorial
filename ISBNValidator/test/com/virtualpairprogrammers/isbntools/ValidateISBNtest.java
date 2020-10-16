package com.virtualpairprogrammers.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNtest {

	@Test
	public void check_a_valid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("second value", result);
	}
	
	@Test
	public void check_an_ivalid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void check_a_valid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781427275103");
		assertTrue("first value", result);
		result = validator.checkISBN("9780544003415");
		assertTrue("second value", result);
	}
	
	@Test
	public void check_an_ivalid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781427275106");
		assertFalse(result);
	}
	
	@Test
	public void ISBN_numbers_ending_in_X_are_valid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue( result);
	}

	
	@Test(expected = NumberFormatException.class)
	public void nine_digit_ISBNs_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
	    validator.checkISBN("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void nonnumberic_ISBNs_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("HelloWorld");
	}
}

