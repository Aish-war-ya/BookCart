package com.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Login 
{
	@FindBy (xpath = "//span[text() = 'Register']")
	private WebElement registerButton;
	
	@FindBy (xpath = "//mat-card-title[text() = ' Login ']")
	private WebElement loginText;
	
	@FindBy (xpath = "//span[text() = 'New User? ']")
	private WebElement newUserText;
	
	@FindBy (xpath = "//input[@placeholder = 'Username']")
	private WebElement usernameField;
	
	@FindBy (xpath = "//input[@placeholder = 'Password']")
	private WebElement passwordField;
	
	@FindBy (xpath = "(//mat-icon[@aria-hidden = 'true'])[3]")
	private WebElement hideEyeIcon;
	
	@FindBy (xpath = "//span[text() = 'Login']")
	private WebElement loginButton;
	
	public POM_Login (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	public void clickOnRegisterButton()
//	{
//		registerButton.click();
//	}
	
	public boolean verifyLoginText()
	{
		return loginText.isDisplayed();
	}
	
	public boolean verifyNewUserText()
	{
		return newUserText.isDisplayed();
	}
	
	public boolean verifyIfRegisterButtonIsDisplayed()
	{
		return registerButton.isDisplayed();
	}
	
	public boolean verifyIfUsernameFieldIsDisplayed()
	{
		return usernameField.isDisplayed();
	}
	
	public String verifyUsernameBackendText()
	{
		return usernameField.getAttribute("placeholder");
	}
	
	public boolean verifyIfPasswordFieldIsDisplayed()
	{
		return passwordField.isDisplayed();
	}
	
	public String verifyPasswordBackendText()
	{
		return passwordField.getAttribute("placeholder");
	}
	
	public boolean verifyIfHideEyeIconIsDisplayed()
	{
		return hideEyeIcon.isDisplayed();
	}
	
	public boolean verifyIfLoginButtonIsDisplayed()
	{
		return loginButton.isDisplayed();
	}
	
	public void enterUsername(String user)
	{
		usernameField.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		passwordField.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
}
