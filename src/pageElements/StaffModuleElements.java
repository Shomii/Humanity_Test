package pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaffModuleElements {

	public final String SHIFT_PLANNING_BUTTON = "//i[@class='primNavQtip__icon icon-shiftPlanning']";
	public final String SHIFT_PLANNING_PAGE_TITLE = "ShiftPlanning - Humanity";
	public final String ADD_EMPLOYEE_BUTTON = "//button[@class='addEmployee add-employee-btn']";
	public final String ADD_EMPLOYEE_POPUP = "//div[@class='add-employee-popup_header']";
	public final String CLOSE_POPUP_WINDOW = "//div[@class='add-employee-popup_header']/i[1]";

	public final String ERROR_MESSAGE = "//div[@id='_status']";
	public final String ERROR_MESSAGE_FIRST_NAME = "You must enter a first name";
	public final String ERROR_MESSAGE_LAST_NAME = "Please make sure";
	public final String ERROR_MESSAGE_POSITION = "Please make sure";

	public final String FIRST_NAME_INPUT_FIELD = "//input[@id='fname_2']";
	public final String FIRST_NAME_1 = "Zika";
	public final String FIRST_NAME_2 = "123Zika123";
	public final String FIRST_NAME_3 = "123456";
	public final String LAST_NAME_INPUT_FIELD = "//input[@id='lname_2']";
	public final String LAST_NAME_1 = "Zikic";
	public final String LAST_NAME_2 = "123Zikic123";
	public final String LAST_NAME_3 = "123456";
	public final String POSITION_INPUT_FIELD = "//input[@id='positions_2-selectized']";
	public final String POSITION_INPUT_1 = "Sample Position";
	public final String POSITION_INPUT_2 = "123Sample Position123";
	public final String POSITION_INPUT_3 = "123456";
	public final String CONTINUE_BUTTON = "//div[@id='add_employee_btn']";

	public final String VERIFY_NEW_EMPLOYEE = "//span[@title='" + FIRST_NAME_1 + " " + LAST_NAME_1 + "']";
	public final String VERIFY_NEW_ALPHANUMERIC_EMPLOYEE = "//span[@title='" + FIRST_NAME_2 + " " + LAST_NAME_2 + "']";
	public final String VERIFY_NEW_NUMERIC_EMPLOYEE = "//span[@title='" + FIRST_NAME_3 + " " + LAST_NAME_3 + "']";

}
