package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class ProfilePage extends SeWrappers {

	@FindBy(xpath="//a[contains(text(),'Profile')]")
	private WebElement profile;
	
	@FindBy(xpath ="//textarea[@placeholder='text here...']")
	private WebElement bioText;
	
	@FindBy(xpath="(//span[contains(text(),'Save')])[2]")
	private WebElement saveButton;
	
	public WebElement getprofile() {
		return profile;
	}
	public WebElement getbioText() {
		return bioText;
	}
	public WebElement getclicksaveButton() {
		return saveButton;
	}
	
	
	
	public void clickprofile() {
		waitForElement(profile,10);
		click(profile);
	}
	public void setbioText(String Automation) {
		waitForElement(bioText, 10);
		typeText(bioText, "Automating w3 Schools using Selenium");
		
	}
	
	public void clicksaveButton() {
		waitForElement(saveButton,10);
		click(saveButton);
	}
	
}
