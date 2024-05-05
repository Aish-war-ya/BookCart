package com.TestPack;

import java.util.concurrent.TimeUnit; 
import org.testng.Assert;
import com.POMPack.POM_Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage 
{
	WebDriver driver;
	POM_Login login;
	Logger log;
	
	@BeforeClass
	public void beforeClass()
	{
		log = LogManager.getLogger(LoginPage.class.getName());

		System.setProperty("webdriver.chrome.driver", "C:\\I-rise\\Notes\\chromedriver-win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/login");
		log.info("URL launched");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
	}
	
	@Test
	public void TC_001()
	{
		log.info("TC_001 started");
		login = new POM_Login(driver);
		boolean result = login.verifyLoginText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_002()
	{
		log.info("TC_002 started");
		login = new POM_Login(driver);
		boolean result = login.verifyNewUserText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_003()
	{
		log.info("TC_003 started");
		login = new POM_Login(driver);
		boolean result = login.verifyIfRegisterButtonIsDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_006()
	{
		log.info("TC_006 started");
		login = new POM_Login(driver);
		boolean result = login.verifyIfUsernameFieldIsDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_007()
	{
		log.info("TC_007 started");
		login = new POM_Login(driver);
		String result = login.verifyUsernameBackendText();
		System.out.println(result);
		Assert.assertEquals(result, "Username");
	}
	
	@Test
	public void TC_010()
	{
		log.info("TC_010 started");
		login = new POM_Login(driver);
		boolean result = login.verifyIfPasswordFieldIsDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_011()
	{
		log.info("TC_001 started");
		login = new POM_Login(driver);
		String result = login.verifyPasswordBackendText();
		System.out.println(result);
		Assert.assertEquals(result, "Password");
	}
	
	@Test
	public void TC_014()
	{
		log.info("TC_014 started");
		login = new POM_Login(driver);
		boolean result = login.verifyIfLoginButtonIsDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_015()
	{
		log.info("TC_015 started");
		login = new POM_Login(driver);
		boolean result = login.verifyIfHideEyeIconIsDisplayed();
		Assert.assertEquals(result, true);
	}
	
	@AfterClass
	public void afterClass()
	{
		log.info("Quitting browser");
		driver.quit();
	}
}
