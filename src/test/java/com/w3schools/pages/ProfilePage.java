package com.w3schools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class ProfilePage extends SeWrappers {
	
		
	@FindBy(xpath="//a[contains(text(),'Profile')]")
	private WebElement profile;

	@FindBy(xpath = "//label[contains(text(),'First Name')]//following::input")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Add your last name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@type='checkbox']/following::span")
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
		
		WebElement iframeElement = driver.findElement(By.xpath("//div[@id='top-nav-bar-placeholder']//following::iframe"));
		driver.switchTo().frame(iframeElement);
		//clickWithJavaScript(profile);
		waitForElement(profile, 10);
		click(profile);
	}
	
	public void setfirstName(String fname) {
		waitForElement(firstName, 10);
		firstName.click();
		firstName.clear();
		typeText(firstName, fname);
	}
	
	public void setlastName(String lname) {
		waitForElement(lastName, 10);
		lastName.click();
		lastName.clear();
		//waitForElement(lastName, 10);
		typeText(lastName, lname);
	}

	public void setbioText(String Automation) {
		waitForElement(bioText, 10);
		typeText(bioText, Automation);

	}

	public void setsubscription() {
		
		if(subscription.isEnabled()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].disabled=true", subscription);
			System.out.println("Checkbox is now disabled");
		}else {
			System.out.println("checkbox is already disabled");
		}
		clickWithJavaScript(subscription);
		//click(subscription);
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
