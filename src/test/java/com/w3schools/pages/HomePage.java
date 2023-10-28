package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class HomePage extends SeWrappers {

@FindBy(xpath="//div[text()='My learning']")
private WebElement homepageLabel;

public WebElement getHomepageLabel() {
	return homepageLabel;
}

public void waitForLearning()
{
	waitForElement(homepageLabel,20);
}

}
