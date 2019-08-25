package pageElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	// PrerequisitesElements
	public static final String HOME_PAGE = "https://www.humanity.com/";
	public static final String LOGIN_PAGE = "//p[contains(text(),'LOGIN')]";
	public static final String E_MAIL_FOR_LOGIN = "//input[@id='email']";
	public static final String PASSWORD_FOR_LOGIN = "//input[@id='password']";
	public static final String E_MAIL = "humanity.test@yahoo.com";
	public static final String PASSWORD = "humanity.test";
	public static final String LOGIN_BUTTON = "//button[contains(text(),'Log in')]";
	// public final String LOGIN_BUTTON = "(//button[@name='login'])[1]";
	// ----------------------------------------------------

	public WebDriver driver;
	public static WebElement element = null;

	// opening web page for inserted web address
	public static void openPage(WebDriver driver, String urlPage) {

		driver.get(urlPage);
	}

	// find web element
	public static WebElement findWebElement(WebDriver driver, String xpathInput) {

		try {
			element = driver.findElement(By.xpath(xpathInput));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// click web element
	public static void clickWebElement(WebDriver driver, String xpathInput) {

		findWebElement(driver, xpathInput).click();
	}

	// fill out web element
	public static void fillWebElement(WebDriver driver, String xpathInput, String fillValue) {

		findWebElement(driver, xpathInput).clear();
		findWebElement(driver, xpathInput).sendKeys(fillValue);
	}

	public static void login(WebDriver driver) {

		// open humanity.com page
		WebDriverHelper.openPage(driver, HOME_PAGE);

		// maximize browser window
		WebDriverHelper.maximizeWindow(driver);

		// navigate to login page
		WebDriverHelper.clickWebElement(driver, LOGIN_PAGE);

		// find input field for email and insert email for login
		WebDriverHelper.fillWebElement(driver, E_MAIL_FOR_LOGIN, E_MAIL);

		// find input field for password and insert password for login
		WebDriverHelper.fillWebElement(driver, PASSWORD_FOR_LOGIN, PASSWORD);

		// click button for login to app
		WebDriverHelper.clickWebElement(driver, LOGIN_BUTTON);
	}

	// finding web element and wait for element to be clickable
	public static WebElement findWebElementClickable(WebDriver driver, String xpathInput) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw e;
		}
		return element;
	}

	// confirms if web element is present
	public static boolean isElementPresent(WebDriver driver, String xpathInput) {
		int numberOfElements = driver.findElements(By.xpath(xpathInput)).size();
		if (numberOfElements > 0) {
			return true;
		} else {
			return false;
		}
	}

	// Confirms if web element is displayed
	public static boolean isDisplayed(WebDriver driver, String xpathInput) {
		element = findWebElement(driver, xpathInput);
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// implicitly wait
	public static void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// explicit wait
	public static void explicitWait(WebDriver driver, String xpathInput) {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(xpathInput)));
	}

	// explicit wait boolean
	public static boolean explicitWaitBoolean(WebDriver driver, String xpathInput) {
		boolean element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id(xpathInput)));
		return element;
	}

	// maximize browser window
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// wait thread
	public static void waitThread(long duration) throws Exception {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			throw e;
		}
	}

	// get text from web element
	public static String getTextFromElement(WebDriver driver, String xpathInput) {
		String text = driver.findElement(By.xpath(xpathInput)).getText();
		return text;
	}

	// get how many element is present on page
	public static int getNumberByXpath(WebDriver driver, String xpathInput) {
		List<WebElement> allElements = driver.findElements(By.xpath(xpathInput));

		int number = allElements.size();
		return number;
	}

}
