package com.spring.task.chargroup.service.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.service.api.IStringCompressor;


/**
 * @author Sapan.Saxena
 * This class comprises of test cases which are used to test StringCompressor's method compress against three test cases.
 *
 */
public class SpringCompressorTest extends BaseTest{
	@Autowired
	 private IStringCompressor stringCompressor;
	 
	@Test
     public void testCompressSimple() {

         String uncompressed = "aaa";
         String compressed = stringCompressor.compress(uncompressed);
         assertEquals("a3", compressed);
     }

     @Test
     public void testCompressMoreComplex() {

         String uncompressed = "aabbbbcaaddddddd";
         String compressed = stringCompressor.compress(uncompressed);
         assertEquals("a2b4ca2d7", compressed);
     }

     @Test
     public void testCompressWithNonOptimizedResult() {

         String uncompressed = "helo";
         String compressed = stringCompressor.compress(uncompressed);
         assertEquals(uncompressed, compressed);
     }
}
