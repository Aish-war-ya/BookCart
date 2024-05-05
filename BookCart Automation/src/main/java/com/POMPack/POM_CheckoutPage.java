package com.POMPack;

import com.UtilityPack.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_CheckoutPage 
{
	@FindBy (xpath = "//input[@placeholder = 'Name']")
	private WebElement nameField;
	
	@FindBy (xpath = "//input[@placeholder = 'Address Line 1']")
	private WebElement address1Field;
	
	@FindBy (xpath = "//input[@placeholder = 'Address Line 2']")
	private WebElement address2Field;
	
	@FindBy (xpath = "//input[@placeholder = 'Pincode']")
	private WebElement pincodeField;
	
	@FindBy (xpath = "//input[@placeholder = 'State']")
	private WebElement stateField;
	
	@FindBy (xpath = "//span[text() = ' Place Order ']")
	private WebElement placeOrderButton;
	
	@FindBy (xpath = "//span[text() = ' Cancel ']")
	private WebElement cancelButton;
	
	public POM_CheckoutPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterName()
	{
		nameField.sendKeys("Aish");
	}
	
	public void enterAddressLine1()
	{
		address1Field.sendKeys("Dastur Nagar");
	}
	
	public void enterAddressLine2()
	{
		address2Field.sendKeys("Amravati");
	}
	
	public void enterPincode()
	{
		pincodeField.sendKeys("444606");
	}
	
	public void enterState()
	{
		stateField.sendKeys("Maharashtra");
	}
	
	public void clickOnPlaceOrder(WebDriver driver)
	{
		Utility.scrollToElement(driver, placeOrderButton);
		placeOrderButton.click();
	}
	
	public void clickOnCancel(WebDriver driver) throws InterruptedException
	{
		Utility.scrollToElement(driver, cancelButton);
		Thread.sleep(1000);
		cancelButton.click();
	}
	
	
	
	
}
