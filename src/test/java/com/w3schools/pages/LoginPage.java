package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3schools.utils.SeWrappers;

public class LoginPage extends SeWrappers {

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@name='current-password']")
	private WebElement password;

	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement login;

	@FindBy(xpath = "//div[@class='Alert_wrapper__Aj7U+']")
	private WebElement errormsg;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement geterrormsg() {
		return errormsg;
	}

	public void setEmail(String user) {
		waitForElement(email, 10);
		typeText(email, user);
	}

	public void setPassword(String pass) {
		waitForElement(password, 10);
		typeText(password, pass);
	}

	public void clickLogin() {
		waitForElement(login, 10);
		click(login);
	}

	public String verifyErrMsg() {
		waitForElement(errormsg, 20);
		String Actualtext = errormsg.getText();
		// System.out.println(Actualtext);
		return Actualtext;

	}

}
