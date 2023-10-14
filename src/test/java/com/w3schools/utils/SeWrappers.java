package com.w3schools.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeWrappers {

	// This class is going to contain all the utility methods with regard to
	// selenium. We are going to create cusomized methods for all selenium built in
	// methods

	public static RemoteWebDriver driver = null;
	//public static WebDriver driver = null;
	public static WebElement verifyTitle;
	public JavascriptExecutor jsExecutor;

	//Launching and closing the Browser
	
	public static void launchBrowser(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		} catch (Exception ex) {
			System.out.println("Problem while launching the browser");
			ex.printStackTrace();
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
//********************************************************************************************************************************************
	//Wait - WebDriver Wait and Fluent Wait
	
	public static void waitForElement(WebElement ele, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// public void pollingWait(WebElement ele)

	public void pollingWait(WebElement ele, int timeout, int pollingFrequency) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(pollingFrequency));

			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
//********************************************************************************************************************************************
	
	// select class
	
	public void SelectbyVisibleText(String visibleText) {
		try {
			WebElement dd = driver.findElement(By.name(visibleText));
			Select dropdown = new Select(dd);
			dropdown.selectByValue(visibleText);
			System.out.println("The dropdown is selected by Visible Text" + visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SelectbyValue(WebElement element, String text) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByValue(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void SelectbyIndex(String id, int value) {
		try {
			WebElement dd = driver.findElement(By.id(id));
			Select dropdown = new Select(dd);
			dropdown.selectByIndex(value);
			System.out.println("The dropdown is selected by index" + value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//********************************************************************************************************************************************
	
	// actions class
	public void actionClick(WebElement element) {
		try {
			Actions actionsClass = new Actions(driver);
			actionsClass.click(element).build().perform();
			System.out.println("Click action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionDoubleClick(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.doubleClick(element).build().perform();
			System.out.println("Double Click action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionMoveToEle(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.moveToElement(element).build().perform();
			System.out.println("Move to Element action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// right click
	public void rightClick(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.contextClick().build().perform();
			System.out.println("Right Click action is performed sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// dragAndDrop
	public void dragAndDrop(WebElement element1, WebElement element2) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.dragAndDrop(element1, element2);
			System.out.println("Drag and Drop action is performed sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// clickAndHold

	public void clickAndHold(WebElement element) {
		Actions actionClass = new Actions(driver);
		actionClass.clickAndHold(element);
		System.out.println("Click and hold action is performed sucessfully");

	}

	// enabled
	public boolean isEnabled(String id, WebElement element) {

		boolean retVal = false;
		try {
			WebElement element1 = driver.findElement(By.id(id));
			retVal = element1.isEnabled();

			System.out.println("The element is " + retVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;

	}

	// displayed needs to be changed)
	public boolean isDisabled(String id) {
		try {
			WebElement element = driver.findElement(By.id(id));
			boolean isDisabled = element.isDisplayed();
			System.out.println("The element is " + isDisabled);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
//********************************************************************************************************************************************

	//Alert
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert Accepted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert cancelled sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAlertText() {
		try {
			String alertText = driver.switchTo().alert().getText();
			System.out.println(alertText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//********************************************************************************************************************************************
	
	// frames
	
	

//********************************************************************************************************************************************

	// window handling
	public void switchToWindow(String windowTitle) {
		try {
			Set<String> winhandles = driver.getWindowHandles();
			for (String winhandle : winhandles) {
				driver.switchTo().window(winhandle);
				if (driver.getTitle().equals(windowTitle))
					break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToChildWindow() {

	}

	public void switchToLastWindow() {

	}

//********************************************************************************************************************************************
	// jsExecutor = scroll down, up, right, left, get title, click using java script
	
	
	public void scrollUp() {
		try {
			jsExecutor.executeScript("window.ScrollTo(0,-document.body.scrollHeight);");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void scrollDown() {
		try {
			jsExecutor.executeScript("window.ScrollTo(0,document.body.scrollHeight);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollLeft() {
		try {
			jsExecutor.executeScript("windows.ScrollTo(-document.body.scrollWidth,0);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollRight() {
		try {
			jsExecutor.executeScript("windws.ScrollTo(document.body.scrollWidth,0);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getTitle() {
		String title="";
		try {
			 title= jsExecutor.executeScript("return document.title;").toString();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return title;
	}

	public void clickWithJavaScript(WebElement element) {
		try {
			jsExecutor.executeScript("argument[0].click();", element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void scrollToElementJavaScript(WebElement element) {
		try {
			jsExecutor.executeScript("argument[0].scrollIntoView(true);", element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	
//********************************************************************************************************************************************
	// sendkeys
	
	public static void sendKeys(WebElement element, String text) {
		try {
			element.sendKeys(text);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void sendKeyswithClear(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void sendKeyswithEnter(WebElement element, String text) {
		try {
			element.sendKeys(text, Keys.ENTER);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//********************************************************************************************************************************************	
	// click
	public void click(WebElement ele) {
		try {
			waitForElement(ele, 20);
			ele.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
//********************************************************************************************************************************************
	// screenshot
	public static void takeScreenshot(String ScreenshotName) {
		 
		//TakesScreenshot 
		
		try {
			File srcFile =  driver.getScreenshotAs(OutputType.FILE);
			File destinationPath = new File("./UIFramework/Screenshot" +ScreenshotName+ ".png");
			//FileHandler.copy(srcFile, destinationPath);
			FileUtils.copyFile(srcFile,destinationPath);
			System.out.println("Screenshot saved to" +destinationPath);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to take screenshot:" + e.getMessage());
		}
	}
	
	
//********************************************************************************************************************************************
	public void typeText(WebElement ele, String text) {
		try {
			waitForElement(ele, 20);
			ele.sendKeys(text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//********************************************************************************************************************************************	

	public void verifyTitle(String title) {

		try {
			String strtitle = driver.getTitle();

			if (title.equalsIgnoreCase(strtitle)) {
				System.out.println("The Expected Title" + title + "is equal to" + strtitle);

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}
