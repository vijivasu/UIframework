package com.w3schools.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class TutorialsPage extends SeWrappers {
	
	@FindBy(xpath= "//input[@placeholder='Search tutorials']")
	private WebElement search;
	
	@FindBy(xpath="//div[@class='card-groups multi-row-group']")
	private WebElement javaResults;
	
	public WebElement getsearch() {
		return search;
	}
	
	public void setsearch(String text) {
		waitForElement(search, 10);
		typeText(search,text);
		sendkeys(search);
	}
	
	public void javaResults(String desiredCourse) {
		desiredCourse ="Learn Java";
		WebElement javaResults = driver.findElement(By.xpath("//div[@class='card-groups multi-row-group']"));
		
		List<WebElement> oneResults = javaResults.findElements(By.tagName("div"));
		for (WebElement oneResult: oneResults) {
			String text = oneResult.getText();
			//System.out.println(text);
			
			if (text.equals(desiredCourse)) {
				oneResult.click();
				break;
				
				
			}
		}
	}
	
	

}
