package com.TestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.BasePack.BaseClass;
import com.POMPack.POM_CheckoutPage;
import com.POMPack.POM_HomePage;
import com.POMPack.POM_Login;
import com.POMPack.POM_MainPage;
import com.POMPack.POM_ShoppingCart;
import com.UtilityPack.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass
{
	WebDriver driver;
	POM_HomePage homepage;
	POM_MainPage mainpage;
	POM_Login loginpage;
	POM_ShoppingCart shoppingCartpage;
	POM_CheckoutPage checkoutpage;
	Logger log;
	
	@BeforeClass (alwaysRun = true)
	public void beforeClass() throws InterruptedException
	{
		log = LogManager.getLogger(TestClass.class.getName());
		
		System.setProperty("webdriver.chrome.driver", "C:\\I-rise\\Notes\\chromedriver-win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		driver.get("https://bookcart.azurewebsites.net/");
		
		log.info("URL launched");
		
		mainpage = new POM_MainPage(driver); 
		mainpage.clickOnLoginButton(driver);
	}
	
	@BeforeMethod (alwaysRun = true)
	public void beforeTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		log.info("Logging in");
		
		loginpage = new POM_Login(driver);
		
		loginpage.enterUsername(Utility.getExcelData("Sheet2", 1, 1));
		loginpage.enterPassword(Utility.getExcelData("Sheet2", 1, 2));
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void testCase1()
	{
		log.info("testCase1 started"); 
		
		homepage = new POM_HomePage(driver);

		boolean result = homepage.verifyTitle();
		Assert.assertTrue(result);
	}
	
	@Test
	public void testCase3() throws InterruptedException, EncryptedDocumentException, IOException
	{
		log.info("testCase3 started"); 
		
		homepage = new POM_HomePage(driver);
		
		homepage.enterInSearchBar(Utility.getExcelData("Sheet2", 1, 0));
		homepage.selectSearchOption();
	}
	
	@Test
	public void testCase5()
	{
		log.info("testCase5 started");
		
		homepage = new POM_HomePage(driver);
		boolean result = homepage.verifyAccountName();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void testCase4() throws EncryptedDocumentException, IOException, InterruptedException
	{
		log.info("testCase4 started");  
		homepage = new POM_HomePage(driver);
		for(int i=1 ; i<=5 ; i++)
		{
			homepage.enterInSearchBar(Utility.getExcelData("Sheet2", i, 0));
//			Thread.sleep(1000);
			homepage.selectSearchOption();
			Thread.sleep(1000);
			homepage.addtocartbooks();
			Thread.sleep(1000);
			driver.navigate().back();			
			Thread.sleep(1000);

		}
		
		driver.navigate().refresh();
		
		homepage.clickOnCartIcon();
		
		shoppingCartpage = new POM_ShoppingCart(driver);
		shoppingCartpage.clickOnCheckoutButton(driver);
		
		checkoutpage = new POM_CheckoutPage(driver);
		checkoutpage.enterName();
		checkoutpage.enterAddressLine1();
		checkoutpage.enterAddressLine2();
		checkoutpage.enterPincode();
		checkoutpage.enterState();
		Thread.sleep(1000);
		checkoutpage.clickOnPlaceOrder(driver);
	}
	
	@Test
	public void endToEnd() throws InterruptedException
	{
		log.info("endToEnd started"); 
		
		homepage = new POM_HomePage (driver);
		homepage.clickOnAddToCart();
		homepage.clickOnCartIcon();
		
		shoppingCartpage = new POM_ShoppingCart(driver);
		shoppingCartpage.clickOnCheckoutButton(driver);
		
		checkoutpage = new POM_CheckoutPage(driver);
		checkoutpage.enterName();
		checkoutpage.enterAddressLine1();
		checkoutpage.enterAddressLine2();
		checkoutpage.enterPincode();
		checkoutpage.enterState();
		Thread.sleep(1000);
		checkoutpage.clickOnPlaceOrder(driver);
	}
	
	@AfterMethod (alwaysRun = true)
	public void afterMethod() throws InterruptedException
	{
		log.info("Logging out"); 
		homepage = new POM_HomePage(driver);
		
		Thread.sleep(1000);
		homepage.clickonDropdown(driver);
		homepage.clickOnLogoutButton(driver);
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass()
	{
		log.info("Quitting browser"); 
		driver.quit();
	}
}
