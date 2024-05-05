package com.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Register 
{
	@FindBy (xpath = "//mat-card-title[text() = ' User Registration ']")
	private WebElement userText;
	
	@FindBy (xpath = "//span[text() = 'Already Registered? ']")
	private WebElement alreadyText;
	
	@FindBy (xpath = "//span[text() = 'Login']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//mat-label[text() = 'First name']")
	private WebElement firstName;
	
	@FindBy (xpath = "//mat-label[text() = 'Last name']")
	private WebElement lastName;
	
	@FindBy (xpath = "//mat-label[text() = 'User name']")
	private WebElement userName;
	
	@FindBy (xpath = "//mat-label[text() = 'Password']")
	private WebElement password;
	
	@FindBy (xpath = "(//mat-icon[@aria-hidden = 'true'])[3]")
	private WebElement passwordEye;
	
	@FindBy (xpath = "//mat-label[text() = 'Confirm Password']")
	private WebElement confirmPassword;
	
	@FindBy (xpath = "(//mat-icon[@aria-hidden = 'true'])[4]")
	private WebElement confirmEye;
	
	@FindBy (xpath = "//mat-label[text() = 'Gender:']")
	private WebElement genderText;
	
	@FindBy (xpath = "//input[@value = 'Male']")
	private WebElement maleRadioButton;
	
	@FindBy (xpath = "//input[@value = 'Female']")
	private WebElement femaleRadioButton;
	
	@FindBy (xpath = "//span[text() = 'Register']")
	private WebElement registerButton;
	
	public POM_Register (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUserText()
	{
		return userText.isDisplayed();
	}
	
	public boolean verifyAlreadyText()
	{
		return alreadyText.isDisplayed();
	}
	
	public boolean verifyLoginButton()
	{
		return loginButton.isDisplayed();
	}
	
	public boolean verifyFirstNameField()
	{
		return firstName.isDisplayed();
	}
	
	public boolean verifyLastNameField()
	{
		return lastName.isDisplayed();
	}
	
	public boolean verifyUserNameField()
	{
		return userName.isDisplayed();
	}
	
	public boolean verifyPasswordField()
	{
		return password.isDisplayed();
	}
	
	public boolean verifyConfirmPasswordField()
	{
		return confirmPassword.isDisplayed();
	}
	
	public boolean verifyPasswordEye()
	{
		return passwordEye.isDisplayed();
	}
	
	public boolean verifyConfirmEye()
	{
		return confirmEye.isDisplayed();
	}
	
	public boolean verifyGenderText()
	{
		return genderText.isDisplayed();
	}
	
	public boolean verifymaleRadioButton()
	{
		return maleRadioButton.isDisplayed();
	}
	
	public boolean verifyFemaleRadioButton()
	{
		return femaleRadioButton.isDisplayed();
	}
	
	public boolean verifyRegisterButton()
	{
		return registerButton.isDisplayed();
	}
	
	public void enterFirstName()
	{
		firstName.sendKeys("Aishwarya");
	}
	
	public void enterLastname()
	{
		lastName.sendKeys("Sonwane");
	}
	
	public void enterUsername()
	{
		userName.sendKeys("abcdef12345");
	}
	
	public void enterPassword()
	{
		password.sendKeys("Pari@123");
	}
	
	public void enterConfirmPassword()
	{
		confirmPassword.sendKeys("Pari@123");
	}
	
	public void selectgender()
	{
		femaleRadioButton.click();
	}
	
	public void clickOnRegister()
	{
		registerButton.click();
	}
	
}
