package test;

import org.testng.annotations.Test;
import pageElements.StaffModuleElements;
import pageElements.WebDriverHelper;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class StaffModuleTest extends StaffModuleElements {

	public WebDriver driver;

	@BeforeTest
	public void preRequisitesSteps() {

		driver = new FirefoxDriver();

		/**
		 * open home page then maximize web browser, navigate to login page and insert
		 * correct credentials for log in
		 */

		WebDriverHelper.login(driver);
	}

	@Test
	public void Staff_1() {

		/**
		 * Checking if all necessary elements for testing adding new employees are present
		 */

		// waiting for page to load
		WebDriverHelper.implicitWait(driver, 15);

		// verify if shift planning button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, SHIFT_PLANNING_BUTTON), true);

		// navigate to shift planning page
		WebDriverHelper.clickWebElement(driver, SHIFT_PLANNING_BUTTON);

		// verify if shift planning page is displayed
		assertEquals(driver.getTitle(), SHIFT_PLANNING_PAGE_TITLE);

		// verify if shift planning button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, ADD_EMPLOYEE_BUTTON), true);

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// verify if popup window is present
		assertEquals(WebDriverHelper.isElementPresent(driver, ADD_EMPLOYEE_POPUP), true);

		// verify if first name input field is present
		assertEquals(WebDriverHelper.isElementPresent(driver, FIRST_NAME_INPUT_FIELD), true);

		// verify if last name input field is present
		assertEquals(WebDriverHelper.isElementPresent(driver, LAST_NAME_INPUT_FIELD), true);

		// verify if position input field is present
		assertEquals(WebDriverHelper.isElementPresent(driver, POSITION_INPUT_FIELD), true);

		// close popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, CLOSE_POPUP_WINDOW);
	}

	@Test()
	public void Staff_2() throws Exception {
		
		/**
		 * Verify if new employee can be added with all empty fields
		 */

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// waiting to insert data
		WebDriverHelper.implicitWait(driver, 10);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// waiting for message error to appear
		WebDriverHelper.waitThread(1000);

		// get text from error message
		String text = WebDriverHelper.getTextFromElement(driver, ERROR_MESSAGE);

		// verify if error message is displayed
		assertTrue(text.contains(ERROR_MESSAGE_FIRST_NAME));

		// close popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, CLOSE_POPUP_WINDOW);
	}

	@Test
	public void Staff_3() throws Exception {
		
		/**
		 * Verify if new employee can be added with only first name field inserted
		 */

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_1);

		// waiting for message error to close
		WebDriverHelper.waitThread(4000);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// get text from error message
		String text = WebDriverHelper.getTextFromElement(driver, ERROR_MESSAGE);

		// verify if error message is displayed
		assertTrue(text.contains(ERROR_MESSAGE_LAST_NAME));

		// close popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, CLOSE_POPUP_WINDOW);
	}

	@Test
	public void Staff_4() throws Exception {

		/**
		 * Verify if new employee can be added with first name field and last name field inserted
		 */
		
		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_1);

		// insert last name into last name input field
		WebDriverHelper.fillWebElement(driver, LAST_NAME_INPUT_FIELD, LAST_NAME_1);

		// waiting for message error to close
		WebDriverHelper.waitThread(4000);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// get text from error message
		String text = WebDriverHelper.getTextFromElement(driver, ERROR_MESSAGE);

		// verify if error message is displayed
		assertTrue(text.contains(ERROR_MESSAGE_POSITION));

		// close popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, CLOSE_POPUP_WINDOW);
	}

	@Test
	public void Staff_5() {
		
		/**
		 * Verify if new employee can be added with all necessary fields inserted
		 */

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_1);

		// insert last name into last name input field
		WebDriverHelper.fillWebElement(driver, LAST_NAME_INPUT_FIELD, LAST_NAME_1);

		// insert position into position input field
		WebDriverHelper.fillWebElement(driver, POSITION_INPUT_FIELD, POSITION_INPUT_1);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// verify if new employee is added
		assertEquals(driver.findElement(By.xpath(VERIFY_NEW_EMPLOYEE)).getText(), FIRST_NAME_1 + " " + LAST_NAME_1);

	}

	@Test // (alwaysRun = true)
	public void Staff_6() throws Exception {
		
		/**
		 * Verify if a new employee can be added when user use data that matching existing employee
		 */

		// wait to start test
		WebDriverHelper.waitThread(2000);

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_1);

		// insert last name into last name input field
		WebDriverHelper.fillWebElement(driver, LAST_NAME_INPUT_FIELD, LAST_NAME_1);

		// insert position into position input field
		WebDriverHelper.fillWebElement(driver, POSITION_INPUT_FIELD, POSITION_INPUT_1);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// wait to create list of employees
		WebDriverHelper.waitThread(2000);

		// verify if exists only one employee with that name
		assertEquals(WebDriverHelper.getNumberByXpath(driver, VERIFY_NEW_EMPLOYEE), 1);

	}

	@Test
	public void Staff_7() throws Exception {

		/**
		 * Verify if new employee can be added when user use alphanumeric data to create new employee
		 */
		
		// wait to start test
		WebDriverHelper.waitThread(2000);

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// waiting for popup window
		WebDriverHelper.implicitWait(driver, 10);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_2);

		// insert last name into last name input field
		WebDriverHelper.fillWebElement(driver, LAST_NAME_INPUT_FIELD, LAST_NAME_2);

		// insert position into position input field
		WebDriverHelper.fillWebElement(driver, POSITION_INPUT_FIELD, POSITION_INPUT_2);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// verify if alphaNumeric data for employee is added
		assertEquals(driver.findElement(By.xpath(VERIFY_NEW_ALPHANUMERIC_EMPLOYEE)).getText(), false);

	}

	@Test
	public void Staff_8() throws Exception {
		
		/**
		 * Verify if new employee can be added when user use numeric data to create new employee
		 */

		// wait to start test
		WebDriverHelper.waitThread(2000);

		// opens popup window for adding new employee
		WebDriverHelper.clickWebElement(driver, ADD_EMPLOYEE_BUTTON);

		// waiting for popup window
		WebDriverHelper.implicitWait(driver, 10);

		// insert first name into first name input field
		WebDriverHelper.fillWebElement(driver, FIRST_NAME_INPUT_FIELD, FIRST_NAME_3);

		// insert last name into last name input field
		WebDriverHelper.fillWebElement(driver, LAST_NAME_INPUT_FIELD, LAST_NAME_3);

		// insert position into position input field
		WebDriverHelper.fillWebElement(driver, POSITION_INPUT_FIELD, POSITION_INPUT_3);

		// click on continue button to finish adding new employee
		WebDriverHelper.clickWebElement(driver, CONTINUE_BUTTON);

		// verify if numeric data for employee is added
		assertEquals(driver.findElement(By.xpath(VERIFY_NEW_NUMERIC_EMPLOYEE)).getText(), false);

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}
}
