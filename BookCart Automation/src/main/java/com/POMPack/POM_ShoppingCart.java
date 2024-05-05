package com.POMPack;

import com.UtilityPack.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_ShoppingCart 
{
	@FindBy (xpath = "(//button[@tabindex = '0'])[4]")
	private WebElement checkoutButton;
	
	@FindBy (xpath = "(//mat-icon[@class = 'mat-icon notranslate material-icons mat-ligature-font mat-icon-no-color'])[5]")
	private WebElement plusButton;
	
	public POM_ShoppingCart (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlusButton()
	{
		plusButton.click();
	}
	
	public void clickOnCheckoutButton(WebDriver driver) throws InterruptedException
	{
		Utility.scrollToElement(driver, checkoutButton);
		Thread.sleep(1000);
		checkoutButton.click();
	}
}
