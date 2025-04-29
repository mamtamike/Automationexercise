package com.functional.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class ProductListPage extends BaseTest {
	@BeforeMethod
	public void verifyProductButtonNavigation() {
		driver.findElement(By.xpath(lc.getProperty("product_button"))).click();

	}

 	//@Test(priority=1)
	public void verifyAllProductList() {
		List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"features_items\"]/div"));
		System.out.println("totall products are: " + products.size());
		for (int i = 0; i < products.size(); i++) {
			System.out.println("product list is: " + products.get(i).getText());
		}
	}
 	@Test(priority=2)
	public void verifySearchProduct() throws InterruptedException {
		
	WebElement search=driver.findElement(By.xpath(lc.getProperty("search_product")));
	System.out.println("search box placeholder is: "+search.getDomAttribute("placeholder"));
	search.sendKeys("sleeveless dress");
    WebElement searchButton = driver.findElement(By.xpath(lc.getProperty("search_button")));
    searchButton.click();
    search.clear();
    searchButton.click();
	}
 	@Test(priority=3)
	public void verifySearchProductWithEnterKey() throws InterruptedException {
    WebElement search=driver.findElement(By.xpath(lc.getProperty("search_product")));
	search.sendKeys("sleeveless");
	search.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	}
	@Test(priority=4)
 	public void verifyAddToCart() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0,500)");	
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("add_to_cart")))));
        Assert.assertTrue(addCart.isEnabled(), "Add to Cart button is not enabled!");
		addCart.click();
        WebElement continueShopping=driver.findElement(By.xpath(lc.getProperty("continue_shopping")));
		continueShopping.click();
	}
	@Test(priority=6)
	public void verifyViewProduct() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,500)");	
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement viewProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lc.getProperty("view_product"))));
        Assert.assertTrue(viewProduct.isEnabled(), "view product is not enabled!");
        viewProduct.click();
        
	}
	@Test(priority=5)
	public void verifyProductCategory() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,500)");
		// women
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
		driver.findElement(By.xpath(lc.getProperty("women"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("dress"))))).click();
		driver.findElement(By.xpath(lc.getProperty("women"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("tops"))))).click();
		driver.findElement(By.xpath(lc.getProperty("women"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("saree"))))).click();

		// men
		driver.findElement(By.xpath(lc.getProperty("men"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("tshirt"))))).click();

		driver.findElement(By.xpath(lc.getProperty("men"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("jeans"))))).click();
		// kids
		driver.findElement(By.xpath(lc.getProperty("kids"))).click();
		   wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("kids_dress"))))).click();
		driver.findElement(By.xpath(lc.getProperty("kids"))).click();
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(lc.getProperty("Tops_Tshirt"))))).click();

	}
}
