package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;

public class W3Wrappers extends SeWrappers {
	LoginPage lp= null;
	
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
		try {
			lp.verifyErrMsg();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return verifyErrMsg();
	}
	

	public void homePageValidation() {
		try {
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			hp.waitForLearning();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
