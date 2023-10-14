package com.w3schools.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;
import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class LoginTest extends SeWrappers {
	
	W3Wrappers w3 = new W3Wrappers();
	
	//Validate login with valid credentials
	
	@Test
	public void loginWithvalidCredentials()
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		try
		{
			w3.loginToW3Schools();
			waitForElement(hp.getHomepageTitle(),15);
			
			String getHomePageTitle=getTitle();
			Assert.assertTrue(driver.getTitle().contains("getHomePageTitle"));
			
			System.out.println("Login successful");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void verifyHomepage() {
		try {
			w3.homePageValidation();
			SeWrappers.waitForElement(SeWrappers.verifyTitle, 1000);
				
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
