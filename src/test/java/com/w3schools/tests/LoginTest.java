package com.w3schools.tests;

import java.time.Duration;

import org.openqa.selenium.By;
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
import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class LoginTest extends SeWrappers {

	W3Wrappers w3 = new W3Wrappers();
	// ReadExcel ReadData = new ReadExcel();

	// Validate login with valid credentials

	@Test(dataProvider = "testDataForLogin")
	public void loginWithvalidCredentials(String userName, String password) {

		try {
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

	@DataProvider(name = "testDataForLogin")
	public Object[][] getData() {
		return new Object[][] { { "vijivasuteju1786@gmail.com", "Saisai@31" },
				{ "vijivasuteju@gmail.com", "Saisai@31" } };
	}
	// Validate login with Invalid credentials

	@Test(dataProvider = "testDataForLogin")
	public void loginwithInvalidCredentials(String userName, String password) {

		try {

			launchBrowser("firefox", "https://profile.w3schools.com/");
			w3.loginToW3Schools(userName, password);
			w3.homePageValidation();
			String getHomePageTitle = "My learning | W3Schools";
			System.out.println("title-->" + driver.getTitle());
			if (driver.getTitle().contains(getHomePageTitle)) {
				System.out.println("Login successful");
			} else {
				w3.verifyErrMsg();
			}

			/*String expectedErrMsg = "A user with this email does not exist";
			Assert.assertEquals(w3.verifyErrMsg(), expectedErrMsg);
			System.out.println("Error message is verifed and matching with expected");*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
