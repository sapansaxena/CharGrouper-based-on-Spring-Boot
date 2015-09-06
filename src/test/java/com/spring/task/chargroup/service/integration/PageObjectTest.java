package com.spring.task.chargroup.service.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import com.spring.task.chargroup.base.test.BaseTest;
import com.spring.task.chargroup.base.test.CharGroupPage;
import static org.junit.Assert.assertEquals;



/**
 * @author Sapan.Saxena
 * Test class for Page Object Pattern based testing of the application page.
 * Server should be up and running and then the tests should be executed. 
 * Makes use of CharGroupPage class object for tests execution and validations.  
 *
 */
public class PageObjectTest extends BaseTest{
	@Autowired
	private ApplicationContext appContext;
    private Properties prop;

	private CharGroupPage page;
	 
	/**
	 * Used to open the browser via selenium APIs.
	 * Uses application.properties to fetch the URL to be opened in the browser. 
	 * Opens an actual Firefox instance and hits the URL in address bar.
	 * This method forms up the Scenario as per the BDD.
	 */
	@Before
	public void openTheBrowser() {
		prop = new Properties();

		Resource resource = appContext.getResource("classpath:application.properties");
		InputStream in;
		try {
			in = resource.getInputStream();
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		page = PageFactory.initElements(new FirefoxDriver(), CharGroupPage.class);
		//Scenario: Server is up and running. User needs to use CharGrouper
		page.open("http://"+prop.getProperty("server.address")+":"+prop.getProperty("server.port"));
	}
	 
	/**
	 * Closes the browser once the excution is done.
	 */
	@After
	public void closeTheBrowser() {
		page.close();
	}
	 
	/**
	 * Test as per BDD where user types a valid text and the result is updated as Success with proper output.
	 * Given, When, Then and And steps of BDD are executed.
	 */
	@Test
	public void whenTheUserTypesValidTextResultShouldGetUpdatedAsSuccess() {
		//Scenario: Described in @Before
		//Given: User needs to use CharGrouper
		//When: User types in text and clicks "Generate" button
		page.generateFor("selenium");
		//Then: User should be able to get the appropriate success notification
		assertEquals("Success", page.checkSuccessNotification());
		//And: The correct output
		assertEquals("e2ilmnsu", page.checkSuccess());
	}
	
	/**
	 * Test as per BDD where user types no text and the result is updated as Error with proper message.
	 * Given, When, But and And steps of BDD are executed.
	 */
	@Test
	public void whenTheUserTypesNoTextResultShouldGetUpdatedAsError() {
		//Scenario: Described in @Before
		//Given: User needs to use CharGrouper
		//When: User types no text and clicks "Generate" button
		page.generateFor("");
		//But: Input is required and cannot be blank. User should get appropriate notification
		assertEquals("Error", page.checkSuccessNotification());
		//And: Valid Message
		assertEquals("Input Required", page.checkSuccess());
	}
	
	/**
	 * Test as per BDD where user types an invalid text and the result is updated as Error with proper message.
	 * Given, When, But and And steps of BDD are executed.
	 */
	@Test
	public void whenTheUserTypesInvalidTextResultShouldGetUpdatedAsError() {
		//Scenario: Described in @Before
		//Given: User needs to use CharGrouper
		//When: User types invalid text and clicks "Generate" button
		page.generateFor("1234");
		//But: Input can only be alphabets. User should get appropriate notification
		assertEquals("Error", page.checkSuccessNotification());
		//And: Valid Message
		assertEquals("Only alphabetical characters allowed", page.checkSuccess());
	}
}
