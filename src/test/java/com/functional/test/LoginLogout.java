package com.functional.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class LoginLogout extends BaseTest {
	
	
	@Test(priority=1)
	public void loginTest() {
		driver.findElement(By.xpath(lc.getProperty("login_link"))).click();
        // Email field
        driver.findElement(By.xpath(lc.getProperty("email_ID"))).sendKeys("test.data@yopmail.com");
        // Password field
        driver.findElement(By.xpath(lc.getProperty("pwd"))).sendKeys("12345@@");
        // Login button
       driver.findElement(By.xpath(lc.getProperty("login_button"))).click();
	
	}

	@Test(priority=2, dependsOnMethods="loginTest")
		   public void logoutTest() {
	    		WebElement logoutbutton=driver.findElement(By.xpath(lc.getProperty("logout_button")));
	    		System.out.println("logout button text: "+logoutbutton.getText());
	    		logoutbutton.click();		
	    	}
	}


