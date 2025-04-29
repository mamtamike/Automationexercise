package com.functional.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class ProductDetailPage extends BaseTest {
	@Test

	public void navigation() {
		driver.navigate().to("https://www.automationexercise.com/product_details/1");		

	}

	//@Test
	public void verifyNavigateToProductDetailPage() {
		

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    try {
		        // Click on the product button
		        WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lc.getProperty("product_button"))));
		        productButton.click();
		        System.out.println("Clicked on Product Button.");

		        // Click on the "view product" button
		        WebElement viewProductButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lc.getProperty("view_product"))));
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductButton);

		        // Attempt normal click, fallback to JavaScript click
		        try {
		            viewProductButton.click();
		        } catch (Exception e) {
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewProductButton);
		        }

		        System.out.println("Navigated to Product Detail Page.");
		    } catch (Exception e) {
		        System.out.println("Error navigating to product detail page: " + e.getMessage());
		    }
		}
		


	 @Test
	public void verifyProductName() {
		WebElement productName = driver.findElement(By.xpath("//h2[contains(text(),'Blue Top')]"));
		Assert.assertEquals(productName.getText(), "Blue Top", "Product name does not match");
	}

    @Test
	public void verifyProductCategory() {
		WebElement category = driver.findElement(By.xpath("//p[contains(text(),'Category: Women > Tops')]"));
		Assert.assertTrue(category.isDisplayed(), "Category is incorrect");
	}

	 @Test
	public void verifyProductPrice() {
		WebElement price = driver.findElement(By.xpath("//span[contains(text(),'Rs. 500')]"));
		Assert.assertEquals(price.getText(), "Rs. 500", "Price does not match");
	}

	@Test
	public void verifyAvailability() {

		WebElement availability = driver.findElement(By.xpath("//p[contains(text(),'In Stock')]"));
		Assert.assertTrue(availability.isDisplayed(), "Availability status is incorrect");
	}

	@Test
	public void verifyCondition() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.pollingEvery(Duration.ofMillis(500));

	    try {
	        WebElement condition = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/div/div/div[2]/div[2]/div[2]/div/p[3]")));

	        Assert.assertTrue(condition.isDisplayed(), "Verify that detail is visible: condition");
	        System.out.println("Condition verified successfully.");
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        Assert.fail("Condition was not found or visible.");
	    }
	}

	 @Test
	public void verifyBrand() {

		WebElement brand = driver.findElement(By.xpath("//p[contains(text(),'Polo')]"));
		Assert.assertTrue(brand.isDisplayed(), "Brand is incorrect");
	}

	@Test
	public void verifyQuantity() {

		driver.findElement(By.xpath("//*[@id=\"quantity\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("2");

	}

	@Test
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
	// @Test
	public void verifyReviewForm() throws InterruptedException {
		 Actions action=new Actions(driver);
		 action.sendKeys(Keys.PAGE_DOWN);
		// name
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("tarek");
		Thread.sleep(2000);
		// email
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("xerevov580@flektel.com");
		// review
		driver.findElement(By.xpath("//*[@id=\"review\"]")).sendKeys("could be added more detail about product");
		Thread.sleep(2000);

		// submit
		driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();
	}
}
