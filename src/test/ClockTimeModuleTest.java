package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.ClockTimeModuleElements;
import pageElements.WebDriverHelper;

public class ClockTimeModuleTest extends ClockTimeModuleElements {

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
	public void Clock_1() {
		
		/**
		 * Checking if Clock Time button is present and and interact with it. 
		 * Checking if correct page is opened.
		 */

		// waiting for page to load
		WebDriverHelper.implicitWait(driver, 15);

		// verify if shift planning button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, CLOCK_TIME_BUTTON), true);

		// navigate to shift planning page
		WebDriverHelper.clickWebElement(driver, CLOCK_TIME_BUTTON);

		// waiting for page to load
		WebDriverHelper.implicitWait(driver, 15);

		// verify if shift planning page is displayed
		assertEquals(driver.getTitle(), CLOCK_TIME_PAGE_TITLE);
	}

	@Test
	public void Clock_2() throws Exception {
		
		/**
		 * Checking if Clock in button is present and and interact with it. 
		 * Checking if Clock in button is present and and interact with it.
		 * Checking if Clock in button is present.
		 */

		// verify if Clock in button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, CLOCK_IN), true);

		// Clocking in
		WebDriverHelper.findWebElementClickable(driver, CLOCK_IN);

		// verify if Clock out button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, CLOCK_OUT), true);

		// Clocking out
		WebDriverHelper.findWebElementClickable(driver, CLOCK_OUT);

		// waiting for clocking out
		WebDriverHelper.waitThread(5000);

		// verify if Clock in button is present
		assertEquals(WebDriverHelper.isElementPresent(driver, CLOCK_IN), true);

	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}
}
