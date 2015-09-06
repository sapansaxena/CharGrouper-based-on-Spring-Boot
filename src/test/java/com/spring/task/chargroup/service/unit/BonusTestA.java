package com.spring.task.chargroup.service.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BonusTestA {
	@Test
    public void test() {

        String s = "1";
        Integer i = 1;

        s = add(s, 1);
        assertEquals("2", s);
        s = add(s, 5);
        assertEquals("7", s);

        i = add(i, 2);
        assertEquals((Integer) 3, i);
        i = add(i, 1);
        assertEquals((Integer) 4, i);
    }
	
	public <T>T add(Object o, int num){
		String name = o.getClass().getSimpleName();
		switch (name){
			case "String":{
				Integer result = Integer.parseInt((String)o)+num;
				return (T)String.valueOf(result);
			}
			case "Integer":{
				Integer result = (int) o+num;
				return (T)result;
			}
		}
		return null;
	}
}
