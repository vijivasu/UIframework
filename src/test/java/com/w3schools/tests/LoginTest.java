package com.w3schools.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;
import com.w3schools.utils.ReadExcel;
import com.w3schools.utils.Reports;
import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class LoginTest extends SeWrappers {

	W3Wrappers w3 = new W3Wrappers();
	Reports report = new Reports();
	// ReadExcel ReadData = new ReadExcel();

	// TC01 - Validate login with valid credentials

	@Test(dataProvider = "testDataForLogin",enabled=false)
	public void loginWithvalidCredentials(String userName, String password) {

		try {

			report.setTCDesc("Validating login with valid credentials");
			launchBrowser("firefox", "https://profile.w3schools.com/");
			w3.loginToW3Schools(userName, password);

			w3.homePageValidation();

			String getHomePageTitle = "My learning | W3Schools";
			System.out.println("title-->" + driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains(getHomePageTitle));
			System.out.println("Login successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*@DataProvider(name = "testDataForLogin")
	public Object[][] getData() {
		return new Object[][] { { "vijivasuteju1786@gmail.com", "Saisai@31" } };
	}*/
	
	// TC02 - Validate login with Invalid credentials

	@Test(dataProvider = "testDataForInvalidLogin", enabled =false)
	public void loginwithInvalidCredentials(String userName, String password) {

		try {
			report.setTCDesc("Validating login with invalid credentials");
			launchBrowser("firefox", "https://profile.w3schools.com/");
			w3.loginToW3Schools(userName, password);
			String expectedErrMsg = "A user with this email does not exist";
			String actualErrrMsg = w3.verifyErrMsg();
			System.out.println(actualErrrMsg + "--" + expectedErrMsg);
			Assert.assertEquals(actualErrrMsg, expectedErrMsg);
			System.out.println("Error message is verifed and matching with expected");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*@DataProvider(name = "testDataForInvalidLogin")
	public Object[][] getDataForInvalid() {
		return new Object[][] { { "vijivasuteju@gmail.com", "Saisai@31" } };
	}*/

	// TC03 - Click on Browse Tutorials and Search for Java and select LearnJava

	@Test (dataProvider ="testDataForLogin")
	public void clickBrowseTutorialLink(String userName, String password) {
		
		report.setTCDesc("Validating Browse Tutorials");
		launchBrowser("firefox", "https://profile.w3schools.com/");
		w3.loginToW3Schools(userName, password);
		w3.homePageValidation();
		w3.search("java");		
	}
	@DataProvider(name = "testDataForLogin")
	public Object[][] getDataforbrowseTutorial() {
		return new Object[][] { { "vijivasuteju1786@gmail.com", "Saisai@31" } };
	}
}
