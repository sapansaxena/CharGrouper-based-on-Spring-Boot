package com.spring.task.chargroup.service.api;

/**
 * @author Sapan.Saxena
 * Interface ICharGrouper which declares a method group.
 *
 */
public interface ICharGrouper {
	/**
	 * Based on internal implementation, declares a contract where a String is first sorted based on characters and then compressed.
	 * @param input String for execution
	 * @return String output
	 */
	public String group(String input);
}
