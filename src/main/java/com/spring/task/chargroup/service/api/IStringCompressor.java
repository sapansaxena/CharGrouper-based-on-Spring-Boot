package com.spring.task.chargroup.service.api;

/**
 * @author Sapan.Saxena
 * Interface IString Compressor with a single method compress.
 *
 */
public interface IStringCompressor {
	/**
	 * Contract method for compression which takes a String as input and outputs based on internal implementation
	 * @param uncompressed String input
	 * @return compressed String based on character occurences
	 */
	public String compress(String uncompressed);
}
