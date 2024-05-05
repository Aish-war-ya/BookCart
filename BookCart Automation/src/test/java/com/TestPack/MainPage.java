package com.TestPack;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.POMPack.POM_MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPage 
{
	WebDriver driver;
	POM_MainPage main;
	Logger log;
	
	@BeforeClass
	public void beforeClass()
	{
		log = LogManager.getLogger(MainPage.class.getName());
		
		System.setProperty("webdriver.chrome.driver", "C:\\I-rise\\Notes\\chromedriver-win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		log.info("Url launched");
	}
	
	@Test
	public void TC_001()
	{
		log.info("TC_001 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyCategoryText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_005()
	{
		log.info("TC_005 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyBiographyText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_008()
	{
		log.info("TC_008 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyFictionText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_011()
	{
		log.info("TC_011 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyMysteryText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_014()
	{
		log.info("TC_014 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyFantasyText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void TC_017()
	{
		log.info("TC_017 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyRomanceText();
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void tst()
	{
		log.info("tst started");
		main = new POM_MainPage(driver);
		String result = main.verifyCategoryCSSbkColor();
		Assert.assertEquals(result, "rgba(0, 0, 0, 0)");
	}
	
	@Test
	public void TC_020()
	{
		log.info("TC_020 started");
		main = new POM_MainPage(driver);
		boolean result = main.verifyPriceFilterText();
		Assert.assertEquals(result, true);
	}
	
	@Test 
	public void TC_021() throws InterruptedException
	{
		log.info("TC_021 started");
		main = new POM_MainPage(driver);
		main.verifySliderPosition(driver);
	}
	
	@Test
	public void TC_022()
	{
		log.info("TC_022 started");
		main = new POM_MainPage(driver);
		String result = main.verifySearchBarBackendText();
		Assert.assertEquals(result, "Search books or authors");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		log.info("Quitting browser");
	}
}
