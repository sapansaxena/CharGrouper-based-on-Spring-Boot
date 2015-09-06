package com.spring.task.chargroup.service.api;

/**
 * @author Sapan.Saxena
 * Contract Interface for IArraySorter. Declares sort method for int array.
 *
 */
public interface IArraySorter {
	/**
	 * Contract sort method which takes int array as input and returns a sorted array of int based on internal implementation
	 * @param unsorted int array
	 * @return sorted int array
	 */
	public int[] sort(int[] unsorted);
}
