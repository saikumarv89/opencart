package pageObjects;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	WebDriver driver;     // here we are using driver instance from Baseclass--in base class we are created webdriver driver=new chromedriver();, that is used here by "webDriver driver" 
		
	// in every page object class we have to create constructor , instand of creating constructor in every pageobjectclass , create constructor in 1 class that will extend into every poc..
	// Here created Constructor for initiating the webDriver in every poc classees , means--- webdriver =new chromeDriver();
	// in future i want to modify , modify here this will reflect in many places..--so this is to avoid duplication.
	
		public BasePage(WebDriver driver) // this webDriver from actual test webDriver d=new ChromeDriver();
		{
			
			this.driver=driver;  // here assigning driver to this class driver.
			PageFactory.initElements(driver, this);   // pageFactory used here...& assigning driver into entire class.
		}
		
	// this we are going to extend into every page object class.

}
