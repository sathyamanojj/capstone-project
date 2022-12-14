package utils;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.testng.Reporter;

import pom.Login;

public class keyword {
WebDriver driver;
	
	public keyword(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	
	
	public void compareText(String expected, String actual, String failureMessage) {
		//Reporter.log("Expected Result = " + expected);
		//Reporter.log("Actual Result = " + actual);
		
		assertTrue(actual.equals(expected), failureMessage + ",");
	}
	
	public void login(String username, String password) {
		Login obj = new Login(driver);
		obj.Hover_Accounts();
		obj.loginWithCredentials(username, password);
	}
	
	public void invalidlogin(String username, String password) {
		Login obj = new Login(driver);
		obj.Hover_Accounts();
		obj.InvalidloginWithCredentials(username, password);
	}
	
  public void Amazon_searchbox()
  {
	  Login obj = new Login(driver);
	  obj.searchtextbox();
  }
  
  public void search_result()
  {
	 
	  Login obj = new Login(driver);
	  obj.result_text();
	 
  }
 public void Average4starrating()
 {
	 Login obj = new Login (driver);
	 obj.CustomerReview();
 }
 public void selectmobile()
 {
	 Login obj = new Login(driver);
	 obj.Select_product();
 }
}
