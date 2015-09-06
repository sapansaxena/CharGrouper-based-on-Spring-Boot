package com.spring.task.chargroup.service.unit;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;


public class BonusBTest {

    @Test
    public void testChangeFooBar() {

        TestClass testClass = new TestClass();
        assertEquals("test", testClass.getFoobar());
        
        Field privateStringField;
			try {
				privateStringField = TestClass.class.getDeclaredField("foobar");
				privateStringField.setAccessible(true);
			    privateStringField.set(testClass, "SUCCESS");
			} catch (NoSuchFieldException | SecurityException|IllegalArgumentException|IllegalAccessException e) {
				e.printStackTrace();
			}
		    
        assertEquals("SUCCESS", testClass.getFoobar());
    }
}

class TestClass {

    private String foobar = "test";

    public String getFoobar() {
        return foobar;
    }
}

