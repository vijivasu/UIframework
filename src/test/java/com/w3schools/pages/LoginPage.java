package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.SeWrappers;

public class LoginPage extends SeWrappers {
	
@FindBy(name="email")
private WebElement email;

@FindBy(xpath="//input[@name='current-password']")
private WebElement password;

@FindBy(xpath="//span[text()='Log in']")
private WebElement login;


public WebElement getEmail() {
	return email;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin() {
	return login;
}









}
