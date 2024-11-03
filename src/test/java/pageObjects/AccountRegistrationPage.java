package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class AccountRegistrationPage extends BasePage{

	

		public AccountRegistrationPage(WebDriver driver) {
			super(driver);
		}

		// Elements 
			@FindBy(name = "firstname")
			WebElement txtFirstname;

			@FindBy(name = "lastname")
			WebElement txtLasttname;

			@FindBy(name = "email")
			WebElement txtEmail;

			@FindBy(name = "telephone")
			WebElement txtTelephone;

			@FindBy(name = "password")
			WebElement txtPassword;

			@FindBy(name = "confirm")
			WebElement txtConfirmPassword;

			@FindBy(name = "agree")
			WebElement chkdPolicy;

			@FindBy(xpath = "//input[@value='Continue']")
			WebElement btnContinue;

			@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
			WebElement msgConfirmation;

			public void setFirstName(String fname) {
				txtFirstname.sendKeys(fname);

			}

			public void setLastName(String lname) {
				txtLasttname.sendKeys(lname);

			}

			public void setEmail(String email) {
				txtEmail.sendKeys(email);

			}

			public void setTelephone(String tel) {
				txtTelephone.sendKeys(tel);

			}

			public void setPassword(String pwd) {
				txtPassword.sendKeys(pwd);

			}

			public void setConfirmPassword(String pwd) {
				txtConfirmPassword.sendKeys(pwd);

			}

			public void setPrivacyPolicy() {
				chkdPolicy.click();

			}

			public void clickContinue() {
				//sol1 
				btnContinue.click();
				
				//sol2 
				//btnContinue.submit();
				
				//sol3
				//Actions act=new Actions(driver);
				//act.moveToElement(btnContinue).click().perform();
							
				//sol4
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("arguments[0].click();", btnContinue);
				
				//Sol 5
				//btnContinue.sendKeys(Keys.RETURN);
				
				//Sol6  
				//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
				
			}

			public String getConfirmationMsg() // here returning string type is mentioned..
			{
				try 
				{
					return (msgConfirmation.getText());  // here return is mentioned why bcoz in method always return type should mention, but in constructor not to mention return type.
				                                       //here return is mentioned why bcoz in this method returning string type...
				
				} 
				
				catch (Exception e)
				{
					return (e.getMessage());

				}

			}
	
}
