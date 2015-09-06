package com.spring.task.chargroup.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.spring.task.chargroup.service.api.IArraySorter;

/**
 * @author Sapan.Saxena
 * ArraySorter implementation of interface IArraySorter. THis class defines sort method based on interface contract.
 *
 */
@Service
public class ArraySorter implements IArraySorter {
	
	@Override
	public int[] sort(int[] unsorted) {
        int[] copy = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(copy);
        return copy;
    }
}
