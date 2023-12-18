package com.w3schools.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w3schools.utils.Reports;
import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class ProfileTest  extends SeWrappers{
	
	W3Wrappers w3 = new W3Wrappers(); 
	Reports report= new Reports();
	LoginTest lt = new LoginTest();
	
	@Test (dataProvider="testDataForLogin")
	public void profilevalidation(String userName , String password, String fname,String lname, String biotext) {
		
	
		report.setTCDesc("Validating Profile page");
		launchBrowser("chrome", "https://profile.w3schools.com/");
		w3.loginToW3Schools(userName, password);
		w3.profilepageValidation(fname,lname,biotext);
	}
	@DataProvider(name = "testDataForLogin")
	public Object[][] getDataforbrowseTutorial() {
		return new Object[][] { { "vijivasuteju1786@gmail.com", "Saisai@31" , "Vijayalakshmi", "Vasudevan", "Automating profile page"} 
		
		};
	}
	
}



