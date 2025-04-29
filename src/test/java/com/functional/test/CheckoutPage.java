package com.functional.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class CheckoutPage extends BaseTest{
	@Test(priority=1)

	public void navigation() {
		driver.navigate().to("https://www.automationexercise.com/product_details/1");	

	}

	@Test(priority=2)
	public void verifyAddToCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	
		   try {
		        // Wait for "Add to Cart" button and click it
		        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'btn btn-default cart')]")));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCart);
		        Thread.sleep(1000); // Give some time after scrolling

		        try {
		            addToCart.click();
		        } catch (Exception e) {
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
		        }
		        System.out.println("Product added successfully.");

		        // Wait for "Continue Shopping" button and click it
		        WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'btn btn-success close-modal btn-block')]")));
		        continueShopping.click();
		        System.out.println("continue shopping");

		    } catch (Exception e) {
		        System.out.println("Error in add to cart: " + e.getMessage());
		    }
	
	}
	@Test(priority=3)

 public void navigateToCheckOutPage() {
		driver.navigate().to("https://www.automationexercise.com/checkout");
}
	@Test(priority=4)
 public void VerifyAddressDetails() {
		List<WebElement> details=driver.findElements(By.xpath("//*[@class='address item box']/li"));
		System.out.println("details size: "+details.size());
		 for (WebElement detail : details) {
	            System.out.println(detail.getText());
	        }
	}
	 
	@Test(priority=5)
	  public void reviewOrder() {
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"cart_info\"]/table/tbody/tr[2]/td[4]/p"));
        Assert.assertEquals(totalPrice.getText(),"Rs. 1000");
    }
 }
