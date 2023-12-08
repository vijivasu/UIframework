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
			hp.verifytutorailPage();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void search(String desiredCourse) {
		tp =  PageFactory.initElements(driver, TutorialsPage.class);
		tp.setsearch(desiredCourse);		
		tp.javaResults(desiredCourse);
	}

	public void profilepageValidation() {
		try
		{
		 pp = PageFactory.initElements(driver, ProfilePage.class);
		 pp.setclickprofile();
		 pp.setbioText("Automating w3 Schools using Selenium");
		 pp.setfirstName("Vijayalakshmi");
		 pp.setlastName("Vasudevan");
		 pp.setsubscription();
		 pp.activityScore();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
