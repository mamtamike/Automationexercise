package com.functional.test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class ContactUs extends BaseTest {
	@Test
	public void verifyNavigateToContactPage() {
		driver.findElement(By.xpath(lc.getProperty("contact_button"))).click();
	}
	@Test
	public void verifyGetInTouchForm(){
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @name='name']"))).sendKeys("harry");

		//email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email' and @name='email']"))).sendKeys("test.data@yopmail.com");


		//subject
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @name='subject']"))).sendKeys("product return");

        //your message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"message\\\"]"))).sendKeys("product quality cheap");

		//choose file
       WebElement uploadFileInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='file' and @name='upload_file']")));
       uploadFileInput.sendKeys(System.getProperty("C:\\eclipse_workspace\\TestAutomationExercise\\src\\test\\resources\\configfiles\\Sample.txt"));
    	
    			
        // Submit the form 
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @name='submit']"))).click();
	
	}
	@Test
	public void feedback() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='feedback@automationexercise.com']"))).click();

	}

}
