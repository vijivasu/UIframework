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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;

public class SeWrappers {

	// This class is going to contain all the utility methods with regard to
	// selenium. We are going to create cusomized methods for all selenium built in
	// methods

	//public static RemoteWebDriver driver = null;
	public static WebDriver driver = null;
	public static WebElement verifyTitle;
	public static JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	public static Reports reports;
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
			Reports.reportStep("PASS", "Browser has been launched successfully");

		} catch (Exception ex) {
			System.out.println("Problem while launching the browser");
			Reports.reportStep("FAIL", "Problem while launching the browser");
			ex.printStackTrace();
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
			Reports.reportStep("PASS", "Browser has been closed successfully");

		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while closing the Browser ");

			ex.printStackTrace();
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			Reports.reportStep("PASS", "Browsers has been closed successfully");

		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while closing the Browsers ");

			ex.printStackTrace();
		}
	}
//********************************************************************************************************************************************
	//Wait - WebDriver Wait and Fluent Wait
	
	public static void waitForElement(WebElement ele, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Reports.reportStep("PASS", "Successfully identified the element");
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while identifying the element");

			ex.printStackTrace();
		}
	}
	
//********************************************************************************************************************************************
	
	// select class
	
	public void SelectbyVisibleText(String visibleText) {
		try {
			WebElement dd = driver.findElement(By.name(visibleText));
			Select dropdown = new Select(dd);
			dropdown.selectByVisibleText(visibleText);
			Reports.reportStep("PASS", "Text is visible and selected from dropdpwn");
			//System.out.println("The dropdown is selected by Visible Text" + visibleText);
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "Text is not visible");
		}

	}

	public void SelectbyValue(WebElement element, String text) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByValue(text);
			Reports.reportStep("PASS", "Textvalue is visible and selected from dropdpwn");
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "Textvalue is not visible");
		}
	}

	public void SelectbyIndex(String id, int value) {
		try {
			WebElement dd = driver.findElement(By.id(id));
			Select dropdown = new Select(dd);
			dropdown.selectByIndex(value);
			Reports.reportStep("PASS", "TextIndex is visible and selected from dropdpwn");
			System.out.println("The dropdown is selected by index" + value);
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "TextIndex is not visible");
		}

	}

//********************************************************************************************************************************************
	
	// actions class
	public void actionClick(WebElement element) {
		try {
			Actions actionsClass = new Actions(driver);
			actionsClass.click(element).build().perform();
			Reports.reportStep("PASS", "Click action is performed sucessfully");
			//System.out.println("Click action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "Click action is not performed");
		}

	}

	public void actionDoubleClick(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.doubleClick(element).build().perform();
			Reports.reportStep("PASS", "DoubleClick action is performed sucessfully");
			//System.out.println("Double Click action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "DoubleClick action is not performed sucessfully");
		}

	}

	public void actionMoveToEle(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.moveToElement(element).build().perform();
			Reports.reportStep("PASS", "Move to Element action is performed sucessfully");
			//System.out.println("Move to Element action is performed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "Move to Element action is not performed sucessfully");
		}

	}

	// right click
	public void rightClick(WebElement element) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.contextClick().build().perform();
			Reports.reportStep("PASS", "RightClick action is performed sucessfully");
			//System.out.println("Right Click action is performed sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "RightClick action is not performed sucessfully");
		}
	}

	// dragAndDrop
	public void dragAndDrop(WebElement element1, WebElement element2) {
		try {
			Actions actionClass = new Actions(driver);
			actionClass.dragAndDrop(element1, element2);
			Reports.reportStep("PASS", "Drag and Drop action is performed sucessfully");
			//System.out.println("Drag and Drop action is performed sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			Reports.reportStep("FAIL", "Drag and Drop action is not performed sucessfully");
		}
	}
	// clickAndHold

	public void clickAndHold(WebElement element) {
		Actions actionClass = new Actions(driver);
		actionClass.clickAndHold(element);
		Reports.reportStep("PASS", "Click and Hold action is performed sucessfully");
		//System.out.println("Click and hold action is performed sucessfully");

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
		boolean retVal = true;
		
		try {
			WebElement element = driver.findElement(By.id(id));
			retVal = element.isDisplayed();
			System.out.println("The element is " + retVal);

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
	
	public void switchToFramebyID(int FrameID) {
		driver.switchTo().frame(FrameID);
	}
	
	public void switchToFramebyIndex(int frameindex) {
		driver.switchTo().frame(frameindex);
	}
	public void switchToFramebyName(String frameByName) {
		driver.switchTo().frame(frameByName);
	}
	public void switchToFramebyElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToDefaultcontent() {
		driver.switchTo().defaultContent();
	}
	

//********************************************************************************************************************************************

	// window handling
	public void switchToWindow(String windowTitle) {
		try {
			String mainWindowHandle = driver.getWindowHandle(); 
			Set<String> winhandles = driver.getWindowHandles();
			for (String winhandle : winhandles) {
				driver.switchTo().window(winhandle);
				if (driver.getTitle().equals(windowTitle))
					System.out.println("The tile of the current window:" +windowTitle);;
					
					driver.switchTo().window(mainWindowHandle);
					System.out.println("Title of the current Window:" +driver.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void switchToChildWindow(String WindowTitle) {
		
	try {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String winhandle : windowHandles) {
			driver.switchTo().window(winhandle);
			if(driver.getTitle().equals(WindowTitle))
				System.out.println("The tile of the child window:" +WindowTitle);
			driver.close();
		}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}

	}

	public void switchToLastWindow() {
		String lastWindowHandle = null;
		Set<String> winHandles = driver.getWindowHandles();
		
		for(String winHandle : winHandles) {
			 lastWindowHandle = winHandle;
		}
		
		driver.switchTo().window(lastWindowHandle);
	}

//********************************************************************************************************************************************
	// jsExecutor = scroll down, up, right, left, get title, click using java script
	
	
	public void scrollUp() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("window.ScrollTo(0,-document.body.scrollHeight);");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void scrollDown() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("window.ScrollTo(0,document.body.scrollHeight);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollLeft() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("windows.ScrollTo(-document.body.scrollWidth,0);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollRight() {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("windws.ScrollTo(document.body.scrollWidth,0);");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getTitle() {
		String title="";
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		try {
			
			 title= jsExecutor.executeScript("return document.title;").toString();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return title;
	}

	public void clickWithJavaScript(WebElement element) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("argument[0].click();", element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void scrollToElementJavaScript(WebElement element) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
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
			File srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
			//waitForElement(ele, 20);
			ele.sendKeys(text);
			Reports.reportStep("PASS", "Successfully types the text in the element");

		} catch (Exception ex) {
			ex.printStackTrace();
			Reports.reportStep("FAIL", "Problem while typing the text in the element");

		}
	}


public void sendkeys(WebElement ele) {
	try {
		ele.sendKeys(Keys.ENTER);
	}catch(Exception ex) {
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
