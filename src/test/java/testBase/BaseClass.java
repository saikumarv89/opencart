package testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;// lag4j
import org.apache.logging.log4j.Logger; // log4j

import org.openqa.selenium.chrome.ChromeOptions;// FOR ChromeOptions
public class BaseClass {
	
public WebDriver driver;   // creatind a instance &&  globally/class level specified  here....
public Logger logger;     // defined here log message variable [logger]..
public ResourceBundle rb;
	

    // BaseClass is for 1] setup method 
                   //   2] teardown method
                   //   3] For Generating Random string, numaric, alphanumaric values
   // baseclass is same for every testcase.. so to avoid duplication , re-usability, we created separate class that contains setup , tear down methods.&& extend into every test case....



    //  [1] Setup Method to initiate the browser
   
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)     // before executing test case , setup method wil execute to initiate webdriver (Browser) 
	{
	 rb=ResourceBundle.getBundle("config");
		if (br.equalsIgnoreCase("chrome"))  // difference bw equals & equalsIgnorecase--eqlIgNORE will ignore case sensitive...better to use equalIgnorecase.. 
		{
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
			
			driver=new ChromeDriver();
			
		}
		else if (br.equalsIgnoreCase("Edge"))
			{
			driver= new EdgeDriver();
			}
		else if (br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
//>>>> creating logger message variable with test case id 
		
		logger=LogManager.getLogger(this.getClass()); // logg message sending variable,, here created log message variable [logger], this variable is used to send log messages with 'testcaseid''
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));   // local app URL
		//driver.get("https://demo.opencart.com/index.php");   // remote App URL
		driver.manage().window().maximize();
	}
	
	
	
	// [2]  TearDown method to close the browser
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

	
	
	
	
  // [3] For Generate Random Values in TestCase We Created this method
	
	public String randomeString()  //here we specified return type is string ..not used void..
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;  //the return will return  the sting into the method(randomNumber)
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString; // this will return the sting into the method(randomNumber)
		
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+num);
	}

	
	// [4] whenever the test is got failed that time we will refer this method
	public String CaptureScreen(String tname) throws IOException
	{
		/*
		Date dt=new Date();
		SimpleDateFormat sp= new SimpleDateFormat("yyyyMMddhhmmss");
		String timestamp=sp.format(dt);
		
		above 3 lines combined into 1 line in below
		 */
		 
		  String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());  // this is for adding timestamp for SCREENSHOT FOR OUR PURPOSE..
		  
		  TakesScreenshot ts=(TakesScreenshot)driver; // here assigning driver(d) to the takescreenshot variable(ts)
		//  File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		   File source = ts.getScreenshotAs(OutputType.FILE); // this will take the screenshot as file type
		   //File target = new File("workspace\\24 Mar 2023\\Mavenseleniumproject1\\Screenshots\fullpage.png");// this statement to save source file the file into this target location
		       //or
		 File targetFile= new File(System.getProperty("user.dir")+"\\Screenshots\fullpage.png");
		  
		  FileUtils.copyFile(source, targetFile);  // this statement will copy source file into target loaction, for that fileUtils not come from java  so we need to download it to pom.xml by mvnrepository & type apache commons.io
		  
		return timeS;
		
		
	}
}
