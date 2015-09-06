package com.spring.task.chargroup.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.spring.task.chargroup.service.api.IStringCompressor;

/**
 * @author Sapan.Saxena
 * StringCompressor implementation of IStringCompressor interface which defines compress method based on interface contract. 
 *
 */
@Service
public class StringCompressor implements IStringCompressor {

        public String compress(String uncompressed) {
        	if(StringUtils.isEmpty(uncompressed))return null;
        	uncompressed = uncompressed.trim();
        	StringBuilder strBuilder = new StringBuilder();
        	int index = 1, count = 1;
        	char prevCharacter = uncompressed.charAt(0);
        	while(index<uncompressed.length()){
        		char character = uncompressed.charAt(index); 
        		if(character == prevCharacter){
        			count+=1;
        		}else{
        			if(count==1)strBuilder.append(prevCharacter); 
        			else strBuilder.append(prevCharacter).append(count);
        			count = 1;
        			prevCharacter = character;
        		}
        		index+=1;
        	}
        	return (count==1)?strBuilder.append(prevCharacter).toString():strBuilder.append(prevCharacter).append(count).toString();
        }
    }
