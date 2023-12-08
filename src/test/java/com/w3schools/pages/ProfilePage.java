package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class ProfilePage extends SeWrappers {

	@FindBy(xpath="//a[contains(text(),'Profile')]")
	private WebElement profile;

	@FindBy(xpath = "//input[@placeholder='Add your first name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Add your last name']")
	private WebElement lastName;

	@FindBy(xpath = "//div[contains(@aria-label, 'true')] /span")
	private WebElement subscription;

	@FindBy(xpath = "//textarea[@placeholder='text here...']")
	private WebElement bioText;

	@FindBy(xpath = "(//span[contains(text(),'Save')])[2]")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@placeholder='(+) number']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//div[text()='Activity Score']/following::div//input")
	private WebElement activityScore;

	public WebElement getprofile() {
		return profile;
	}

	public WebElement getbioText() {
		return bioText;
	}

	public WebElement getclicksaveButton() {
		return saveButton;
	}

	public WebElement getfirstName() {
		return firstName;
	}

	public WebElement getlastName() {
		return lastName;
	}

	public WebElement getsubscription() {
		return subscription;
	}

	public WebElement getphoneNumber() {
		return phoneNumber;
	}

	public WebElement getactivityScore() {
		return activityScore;
	}

	public void setclickprofile() {
		//waitForElement(profile, 30);
		clickWithJavaScript(profile);
		//click(profile);
	}

	public void setbioText(String Automation) {
		waitForElement(bioText, 10);
		typeText(bioText, Automation);

	}

	public void setfirstName(String fname) {
		typeText(firstName, fname);
	}

	public void setlastName(String lname) {
		typeText(lastName, lname);
	}

	public void setsubscription() {
		boolean subs = subscription.isEnabled();
		System.out.println(subs);
		click(subscription);
	}
	
	public void phoneNumber(String pnum) {
		typeText(phoneNumber, pnum);
		
	}
	
	public void activityScore() {
		boolean score = activityScore.isEnabled();
		System.out.println(score);
		click(activityScore);
	}

	public void clicksaveButton() {
		waitForElement(saveButton, 10);
		click(saveButton);
	}

}
