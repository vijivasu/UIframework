package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;
import com.w3schools.pages.ProfilePage;
import com.w3schools.pages.TutorialsPage;

public class W3Wrappers extends SeWrappers {
	LoginPage lp = null;
	HomePage hp = null;
	TutorialsPage tp = null;
	ProfilePage pp = null;

	public void loginToW3Schools(String userName, String password) {
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);

			lp.setEmail(userName);
			lp.setPassword(password);
			lp.clickLogin();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String verifyErrMsg() {
		String errorText = "";
		try {
			errorText = lp.verifyErrMsg();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return errorText;
	}

	public void homePageValidation() {
		try {
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			hp.waitForLearning();
			hp.setclickBrowseTutorial();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String verifyTutorialLandingpage() {

		String verifylandingPage = "";
		try {
			verifylandingPage = hp.verifytutorailPage();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return verifylandingPage;

	}
		
	public void search(String text) {
		tp =  PageFactory.initElements(driver, TutorialsPage.class);
		tp.setsearch(text);		
		tp.javaResults();
	}

	public void profilepageValidation() {
		 pp = PageFactory.initElements(driver, ProfilePage.class);
		 pp.clickprofile();
	}
}
