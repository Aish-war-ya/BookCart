package com.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_HomePage 
{
	@FindBy (xpath = "//input[@placeholder = 'Search books or authors']")
	private WebElement searchBar;
	
	@FindBy (xpath = "//mat-option[@role = 'option']")
	private WebElement option;
	
	@FindBy (xpath = "//app-addtocart[@ng-reflect-book-id = '2']")
	private WebElement addToCartButton;
	
	@FindBy (xpath = "//button[@class = 'mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base']")
	private WebElement addtocart;
	
	@FindBy (xpath = "(//button[@tabindex = '0'])[3]")
	private WebElement cartIcon;
	
	@FindBy (xpath = "//span[@class = 'mdc-button__label']")
	private WebElement titleName;
	
	@FindBy (xpath = "(//span[@class = 'mdc-button__label'])[2]")
	private WebElement account; 
	
	@FindBy (xpath = "//span[text() = 'Logout']")
	private WebElement logoutButton;
	
	@FindBy (xpath = "//span[text() = ' abcdef12345']")
	private WebElement accountName;
	
	public POM_HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterInSearchBar(String search) 
	{
		searchBar.sendKeys(search);
	}
	
	public void selectSearchOption()
	{
		option.click();
	}
	
	public void clickOnAddToCart()
	{
		addToCartButton.click();
	}
	
	public void addtocartbooks()
	{
		addtocart.click();
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public boolean verifyTitle()
	{
		boolean result = titleName.isDisplayed();
		return result;
	}
	
	public boolean verifyAccountName()
	{
		return accountName.isDisplayed();
	}
	
	public void clickonDropdown (WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(account).click().build().perform();
	}
		
	public void clickOnLogoutButton (WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(logoutButton).click().build().perform();
	}
}
