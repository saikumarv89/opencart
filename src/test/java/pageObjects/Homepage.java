package pageObjects;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage
{
	
	// Creating constructor for invoking parent class (base page) constructor into child class(home page) by super keyword..
	// And passing homepage driver instance(webdriver river) into parent class constructor by super keyword(super(driver))....
	                //             |
	               //              |
	public Homepage(WebDriver driver) // here this wil get the driver instance bcoz in actual test case we will create the object for the homepage.
		{
		super(driver);  // here to invoke parent class constructor into child class ,used super keyword.
		              //And passing homepage driver instance(webdriver river) into parent class constructor by super keyword(super(driver)).
		
	
		}


		// Elements
		@FindBy(xpath = "//span[normalize-space()='My Account']")
		WebElement lnkMyaccount;

		@FindBy(xpath = "//a[normalize-space()='Register']")
		WebElement lnkRegister;

		// Action Methods
		public void clickMyAccount() {
			lnkMyaccount.click();
		}

		public void clickRegister() {
			lnkRegister.click();
		}
		


}




