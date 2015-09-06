package com.spring.task.chargroup.base.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author Sapan.Saxena
 * CharGroup page class build on Page object pattern.
 * Declares Webdriver elements present on the landing page and performs executions as passed on by Test cases built on selenium.
 *
 */
public class CharGroupPage {

		protected WebDriver driver;
		private WebElement q;

		private WebElement btn;
		
		/**
		 * Default constructor of CharGroupPage class.
		 */
		public CharGroupPage(){
			
		}

		/**
		 * Constructor for CharGroupPage with WebDriver as attribute.
		 * @param driver Webdriver
		 */
		public CharGroupPage(WebDriver driver) {
			this.driver = driver;
		}
		/**
		 * Method used to open url in browser during test.
		 * @param url String URL to open in browser.
		 */
		public void open(String url) {
			driver.get(url);
		}
		/**
		 * Method used to close the browser.
		 */
		public void close() {
			driver.quit();
		}
		/**
		 * This method is used to find the textbox and the button on the rendered page.
		 * The input is sent to the textbox which is discovered by id and then the button, which is also discovered by if, is clicked.
		 * @param input String text to sort and compress.
		 */
		public void generateFor(String input) {
			q= driver.findElement(By.id("textInput"));
			btn = driver.findElement(By.id("clickbtn"));
			q.sendKeys(input);
			btn.click();
			}
		
		/**
		 * This method is used to get the notification text(Success/Error) rendered on page in element by id 'code'
		 * @return String text rendered on page for notification.
		 */
		public String checkSuccessNotification() {
				WebElement div = driver.findElement(By.id("code"));
				return div.getText();
			}
		
		/**
		 * This method is used to get the output rendered on the page in element by id 'output'.
		 * @return String text rendered within a span on page for output.
		 */
		public String checkSuccess() {
			WebElement span = driver.findElement(By.id("output"));
			return span.getText();
		}
}
