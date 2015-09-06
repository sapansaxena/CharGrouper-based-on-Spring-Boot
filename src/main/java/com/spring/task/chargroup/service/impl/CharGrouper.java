package com.spring.task.chargroup.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.task.chargroup.service.api.IArraySorter;
import com.spring.task.chargroup.service.api.ICharGrouper;
import com.spring.task.chargroup.service.api.IStringCompressor;

/**
 * @author Sapan.Saxena
 * CharGrouper class implementation of ICharGrouper which defined group method based on interface contract.
 * IArraySorter and IStringCompressor are autowired and injected via Spring container
 * The Rest Controller class for exposing group method resource via REST API. 
 *
 */
@RestController
@RequestMapping("/rest/")
@Service
public class CharGrouper implements ICharGrouper {
	
	private String regex = "[A-Za-z ]*";
	
	@Autowired
	IArraySorter arraySorter;

	@Autowired
	IStringCompressor stringCompressor;	
	
	@Override
	@RequestMapping(value = "chargroup/{input}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String group(@PathVariable String input) {
		if(StringUtils.isEmpty(input) || !input.matches(regex))return null;
		input = input.toLowerCase();
		int[] inputArray = new int[input.length()];
		for(int i=0;i<input.length();i++){
			inputArray[i] = input.charAt(i);
		}
		inputArray = arraySorter.sort(inputArray);
		char[] outputArray = new char[inputArray.length];

		for(int i=0;i<inputArray.length;i++){
			outputArray[i] = (char) inputArray[i];
		}
		String sortedInput = String.valueOf(outputArray);
		return stringCompressor.compress(sortedInput);
	}
	

}
