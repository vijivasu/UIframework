package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;

public class W3Wrappers extends SeWrappers{
	
	public static LoginPage lp= new LoginPage();
	public static HomePage hp= new HomePage();
	
	public  W3Wrappers()
	{
		lp=PageFactory.initElements(driver, LoginPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);

	}
	
	
	public void loginToW3Schools() {
		try
		{
			//LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
			
			SeWrappers.launchBrowser("firefox","https://profile.w3schools.com/");
			
			typeText(lp.getEmail(),"vijivasuteju1786@gmail.com");
			typeText(lp.getPassword(), "Saisai@31");
			click(lp.getLogin());
			

			
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem while logging in W3Schools");
			ex.printStackTrace();
		}
	}
	
	public void homePageValidation() {
		try {
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	

} 
