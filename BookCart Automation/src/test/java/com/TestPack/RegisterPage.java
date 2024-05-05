package com.TestPack;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.POMPack.POM_Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPage 
{
	WebDriver driver;
	POM_Register register;
	Logger log;
	
	@BeforeClass
	public void beforeClass()
	{
		log = LogManager.getLogger(RegisterPage.class.getName());
		
		System.setProperty("webdriver.chrome.driver", "C:\\I-rise\\Notes\\chromedriver-win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/register");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		log.info("URL launched");
	}
	
	@Test
	public void TC_001()
	{
		log.info("TC_001 started");
		register = new POM_Register(driver);
		boolean result = register.verifyUserText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_002()
	{
		log.info("TC_002 started");
		register = new POM_Register(driver);
		boolean result = register.verifyAlreadyText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_003()
	{
		log.info("TC_003 started");
		register = new POM_Register(driver);
		boolean result = register.verifyLoginButton();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_006()
	{
		log.info("TC_006 started");
		register = new POM_Register(driver);
		boolean result = register.verifyFirstNameField();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_010()
	{
		log.info("TC_010 started");
		register = new POM_Register(driver);
		boolean result = register.verifyLastNameField();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_014()
	{
		log.info("TC_014 started");
		register = new POM_Register(driver);
		boolean result = register.verifyUserNameField();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_018()
	{
		log.info("TC_018 started");
		register = new POM_Register(driver);
		boolean result = register.verifyPasswordField();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_022()
	{
		log.info("TC_022 started");
		register = new POM_Register(driver);
		boolean result = register.verifyConfirmPasswordField();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_026()
	{
		log.info("TC_026 started");
		register = new POM_Register(driver);
		boolean result = register.verifyPasswordEye();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_028()
	{
		log.info("TC_028 started");
		register = new POM_Register(driver);
		boolean result = register.verifyConfirmEye();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_030()
	{
		log.info("TC_030 started");
		register = new POM_Register(driver);
		boolean result = register.verifyGenderText();
		Assert.assertEquals(result, true);
	}
	
//	@Test
//	public void TC_031()
//	{
//		register = new POM_Register(driver);
//		boolean result = register.verifymaleRadioButton();
//		Assert.assertEquals(result, true);
//	}
//	
//	@Test
//	public void TC_035()
//	{
//		register = new POM_Register(driver);
//		boolean result = register.verifyFemaleRadioButton();
//		Assert.assertEquals(result, true);
//	}
	
	@Test
	public void TC_042()
	{
		log.info("TC_042 started");
		register = new POM_Register(driver);
		boolean result = register.verifyRegisterButton();
		Assert.assertEquals(result, true);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		log.info("Quitting browser");
	}
}
