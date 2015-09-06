package com.spring.task.chargroup.service.unit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.service.api.IArraySorter;


/**
 * Test for ArraySorter class
 * ArraySorter class defines method sort() which takes an integer array as input and 
 * returns a sorted array using the internal implementation of the sort method of java.util.Arrays class.
 * @author Sapan.Saxena
 *
 */
public class ArraySorterTest extends BaseTest{
	@Autowired
	 private IArraySorter arraySorter;
	
	/**
	 * Test class for sorting an array of mixed integers with positive and negative input and 0. 
	 * Tests that the original array is unchanged and a copy of the input array is sorted and returned.
	 * Input array is verified against the same set of integers in an array.
	 */
	 @Test
	    public void testSortOriginalArrayUnchanged(){
		 int[] array = new int[]{0,-5,50,2,-5, 2, 2};
		 int[] expected = new int[]{-5,-5,0,2,2,2,50};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(new int[]{0,-5,50,2,-5, 2, 2}, array);
		 
	 }
		
	 /**
	 * Test class for sorting an array of already sorted integer numbers.
	 * Output array of integers is verified/asserted against the input array.
	 * Also, output array is verified against input array as method sort is using copyOf method of java.util.Arrays to sort
	 */
	@Test
	    public void testSortForSorted(){
		 int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, array);
		Assert.assertTrue(array!= sorted);
	 }
	 
	/**
	 * Test class for sorting an array of already sorted integer numbers in a reverse order.
	 * Output array of integers is verified/asserted against the input array's reverse order.
	 */
	 @Test
	    public void testSortForReverseSorted(){
		 int[] array = new int[]{5,4,3,2,1};
		 int[] expected = new int[]{1,2,3,4,5};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
	 * Test class for sorting an array of mixed integers with positive and negative input and 0.
	 * Output array of integers is verified/asserted against an array with expected order of input numbers.
	 */
	 @Test
	    public void testSortForMixedIntegers(){
		 int[] array = new int[]{5,-3500,3465,0,-5000};
		 int[] expected = new int[]{-5000,-3500,0,5, 3465};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
	 * Test class for sorting a blank array via the sort method of ArraySorter.
	 * Output array is verified/asserted against an empty array.
	 */
	 @Test
	    public void testSortForBlankArray(){
		 int[] array = new int[]{};
		 int[] expected = new int[]{};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
     * Test class for sorting an array of all 0 valued numbers.
	 * Output array of integers is verified/asserted against an array all numbers as 0 of the same size.
	 */
	 @Test
	    public void testSortForAllZeroes(){
		 int[] array = new int[]{0,0,0,0,0};
		 int[] expected = new int[]{0,0,0,0,0};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
	 * Test class for sorting an array of all repeated non-zero integers.
	 * Output array of integers is verified/asserted against an array of all repeated numbers as in the input array.
	 */
	 @Test
	    public void testSortForAllNonZeroesRepeated(){
		 int[] array = new int[]{1,1,1,1,1,1,1,1};
		 int[] expected = new int[]{1,1,1,1,1,1,1,1};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
	 * Test class for sorting an array of only one non-zero integer.
	 * Output array of integers is verified/asserted against an array of only one non-zero integer as in the input array.
	 */
	 @Test
	    public void testSortForOneNumberArray(){
		 int[] array = new int[]{5};
		 int[] expected = new int[]{5};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
	 
	 /**
	 * Test class for sorting an array of mixed integers with positive and negative input and 0, where some of the integers are repeated.
	 * Output array of integers is verified/asserted against an array with expected order of input numbers.
	 */
	 @Test
	    public void testSortForFewRepeated(){
		 int[] array = new int[]{0,-5,50,2,-5, 2, 2};
		 int[] expected = new int[]{-5,-5,0,2,2,2,50};
		int[]sorted = arraySorter.sort(array);
		Assert.assertArrayEquals(sorted, expected);
		 
	 }
}
