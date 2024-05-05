package com.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_MainPage 
{
	@FindBy (xpath = "//span[text()= ' Login ']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//a[text() = 'All Categories']")
	private WebElement categoryText;
	
	@FindBy (xpath = "//a[text() = 'Biography']")
	private WebElement biographyText;
	
	@FindBy (xpath = "//a[text() = 'Fiction']")
	private WebElement fictionText;
	
	@FindBy (xpath = "//a[text() = 'Mystery']")
	private WebElement mysteryText;
	
	@FindBy (xpath = "//a[text() = 'Fantasy']")
	private WebElement fantasyText;
	
	@FindBy (xpath = "//a[text() = 'Romance']")
	private WebElement romanceText;
	
	@FindBy (xpath = "//mat-card-title[text() = ' Price Filter ']")
	private WebElement priceFilterText;
	
	@FindBy (xpath = "//div[@class = 'mdc-slider__track--inactive']")
	private WebElement slider;
	
	@FindBy (xpath = "//input[@placeholder = 'Search books or authors']")
	private WebElement searchBar;
	
	public POM_MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCategoryText()
	{
		return categoryText.isDisplayed();
	}
	
	public String verifyCategoryCSSbkColor()
	{
		return categoryText.getCssValue("background-color");
	}
	
	public boolean verifyBiographyText()
	{
		return biographyText.isDisplayed();
	}
	
	public boolean verifyFictionText()
	{
		return fictionText.isDisplayed();
	}
	
	public boolean verifyMysteryText()
	{
		return mysteryText.isDisplayed();
	}
	
	public boolean verifyFantasyText()
	{
		return fantasyText.isDisplayed();
	}
	
	public boolean verifyRomanceText()
	{
		return romanceText.isDisplayed();
	}
	
	public boolean verifyPriceFilterText()
	{
		return priceFilterText.isDisplayed();
	}
	
	public void verifySliderPosition(WebDriver driver) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.clickAndHold(slider).perform();
		action.moveByOffset(100, 0).build().perform();
		Thread.sleep(3000);
	}
	
	public String verifySearchBarBackendText()
	{
		return searchBar.getAttribute("placeholder");
	}
	
	public void clickOnLoginButton(WebDriver driver)
	{
		loginButton.click();
	}
}
