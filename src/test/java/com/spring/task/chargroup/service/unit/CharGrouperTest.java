package com.spring.task.chargroup.service.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.service.api.ICharGrouper;

/**
 * @author Sapan.Saxena
 * This class comprises of test cases which test complete end-to-end functionality of CharGrouper's group method.
 *
 */
public class CharGrouperTest extends BaseTest{
	@Autowired
	private ICharGrouper charGrouper;
	
	/**
	 * Test case which verifies a valid input against expected output.
	 */
	@Test
	public void testGroupWithInput(){
	assertEquals("a4bins2uz", charGrouper.group("abzuaaissna"));
	}
	
	/**
	 * Test case which verifies a valid input with spaces against expected output.
	 */
	@Test
	public void testGroupWithSpaces(){
	assertEquals("dehl3o2rw", charGrouper.group("hello world"));
	}

	/**
	 * Test case which verifies a valid input with mixed case characters against expected output.
	 */
	@Test
	public void testGroupWithUpperCase(){
	assertEquals("dehl3o2rw", charGrouper.group("Hello World"));
	}
	
	/**
	 * Test case which verifies a null input with a null output.
	 */
	@Test
	public void testGroupWithNull(){
	assertEquals(null, charGrouper.group(null));
	}
	
	/**
	 * Test case which verifies a blank String input with a blank String output.
	 */
	@Test
	public void testGroupWithBlankString(){
	assertEquals(null, charGrouper.group(""));
	}
	
	/**
	 * Test case which verifies an invalid input with mixed alphanumeric characters against null output.
	 */
	@Test
	public void testGroupWithNumerals(){
	assertEquals(null, charGrouper.group("abc123"));
	}
	
	/**
	 * Test case which verifies an invalid input with mixed alphanumeric characters and special characters against null output.
	 */
	@Test
	public void testGroupWithSpecialCharacters(){
	assertEquals(null, charGrouper.group("abc##$123"));
	}
}
