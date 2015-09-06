package com.spring.task.chargroup.service.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.mockito.Mockito.*;


import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.service.api.IArraySorter;
import com.spring.task.chargroup.service.api.ICharGrouper;
import com.spring.task.chargroup.service.api.IStringCompressor;
import com.spring.task.chargroup.service.impl.CharGrouper;
import com.spring.task.chargroup.service.impl.StringCompressor;

/**
 * @author Sapan.Saxena
 * This class comprises of a single test case which executes unit test of CharGrouper class's method group.
 * All dependencies are mocked/spied out.
 *
 */
public class CharGrouperTestWithMockito extends BaseTest {
	@InjectMocks
	 private ICharGrouper charGrouper = new CharGrouper();
	
	@Before
  public void initMocks(){
      MockitoAnnotations.initMocks(this);
  }
	
	@Mock
	 private IArraySorter arraySorter;
	
	@Spy
	private IStringCompressor stringCompressor = new StringCompressor();
	
	/**
	 * All inputs other than abcdef give an output of a blank string "".
	 * With abcdef, output is "SUCCESS".
	 * Also, verified by mocked out call of arraySorter's sort method, the group method is called exactly once.
	 */
	@Test
	public void testGroup(){
		String input = "abcdef";
		String input2 = "other";
		int[] numbers = new int[]{97, 98, 99, 100, 101, 102};
		int[] numbersOthers = new int[]{};
		
		 Mockito.when(arraySorter.sort(any(int[].class))).thenReturn(numbersOthers);
		 Mockito.when(arraySorter.sort(numbers)).thenReturn(numbers);

		 Mockito.doReturn("").when(stringCompressor).compress(anyString());
		 Mockito.doReturn("SUCCESS").when(stringCompressor).compress("abcdef");
		 
		 String output = charGrouper.group(input);
		 String outputOthers = charGrouper.group(input2);
         assertEquals("SUCCESS", output);
         assertEquals("", outputOthers);
         verify(arraySorter, times(1)).sort(numbers);
	}
}
