package com.w3schools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.w3schools.utils.SeWrappers;

public class HomePage extends SeWrappers {

	@FindBy(xpath = "//div[text()='My learning']")
	private WebElement homepageLabel;

	public WebElement getHomepageLabel() {
		return homepageLabel;
	}

	@FindBy(xpath = "//button[contains(text(),'Browse tutorials')]")
	private WebElement clickBrowseTutorial;

	public WebElement getclickBrowseTutorial() {
		return clickBrowseTutorial;
	}

	@FindBy(xpath = "//h2[contains(text(),'All tutorials')]")
	private WebElement tutorialPageValidation;

	public void setclickBrowseTutorial() {
		waitForElement(clickBrowseTutorial, 10);
		click(clickBrowseTutorial);
	}

	public void waitForLearning() {
		waitForElement(homepageLabel, 20);
	}

	public String verifytutorailPage() {
		boolean landingpage = tutorialPageValidation.isDisplayed();
		String tutorialPage = tutorialPageValidation.getText();
		System.out.println(tutorialPage);
		return tutorialPage;

	}

}
