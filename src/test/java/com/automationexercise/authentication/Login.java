package com.automationexercise.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;
import com.automationexercise.util.ReadXlsData;

public class Login extends BaseTest {
	
    
    @Test(dataProviderClass = ReadXlsData.class, dataProvider = "testdata")
    public void loginTest(String email, String password) {
        try {
        	//login link
        	WebElement button= driver.findElement(By.xpath(lc.getProperty("login_link")));
    		System.out.println("signup/login button enable: " + button.isEnabled());
    		System.out.println("Text visible on menu bar is: " + button.getText());
    		button.click();
            // Email field
            WebElement emailInput = driver.findElement(By.xpath(lc.getProperty("email_ID")));
            System.out.println("Email field placeholder: " + emailInput.getDomAttribute("placeholder"));
            emailInput.sendKeys(email);

            // Password field
            WebElement pwdInput = driver.findElement(By.xpath(lc.getProperty("pwd")));
            System.out.println("Password field placeholder: " + pwdInput.getDomAttribute("placeholder"));
            pwdInput.sendKeys(password);

            // Login button
            WebElement loginButton = driver.findElement(By.xpath(lc.getProperty("login_button")));
            System.out.println("Login button displayed: " + loginButton.isDisplayed());
            System.out.println("Login button text: " + loginButton.getText());
            System.out.println("Login button enabled: " + loginButton.isEnabled());

            loginButton.click();
        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
        }
       
     
    }
}
