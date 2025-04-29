package com.functional.test;


	import java.time.Duration;
import java.util.List;

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

	public class CartPage extends BaseTest {
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
		public void navigateCartPage() {
			driver.findElement(By.xpath(lc.getProperty("cart_button"))).click();	
		}
	    @Test(priority =4)
	    public void testPageTitle() {
	        String expectedTitle = "Automation Exercise - Checkout";
	        String actualTitle=driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	    }
	    

	    @Test(priority = 5)
	    public void testHomeLinkPresence() {
	        WebElement homeLink = driver.findElement(By.linkText("Home"));
	        Assert.assertTrue(homeLink.isDisplayed());
	    }
	    @Test(priority=6)
	    public void testProceedToCheckoutButton() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement checkoutButton=    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[class='btn btn-default check_out']")));

	        Assert.assertTrue(checkoutButton.isDisplayed());
	        Assert.assertTrue(checkoutButton.isEnabled());
	        
	    }

	    @Test(priority=7)
	    public void testCartItemTable() {
	    	List<WebElement> rowElement = driver
					.findElements(By.xpath("//table[@id='cart_info_table']/thead/tr"));
			System.out.println(rowElement.size());
			List<WebElement> columnElement = driver
					.findElements(By.xpath("//table[@id='cart_info_table']/thead/tr[1]/td"));
			System.out.println(columnElement.size());
			
			
			
			for(int i=1; i<=rowElement.size(); i++) {
				for(int j=2; j<=columnElement.size(); j++) {
					System.out.print(driver.findElement(By.xpath("//table[@id='cart_info_table']/thead/tr[ " + i + " ]/td[ " + j + "]")).getText()+" ");
					
				}
				System.out.println();
			}
			System.out.println("all cart item printed successfully");
	       
	    }
	   
	      //  @Test(priority=8)
	        public void removeCartProduct() {
	        	driver.findElement(By.xpath("")).click();
	        	
	        }
	      //  @Test(priority=9)
	        public void emptyCart() {
	        	WebElement emptyCart= driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p/b"));
	        	Assert.assertEquals(emptyCart.getText(), "Cart is empty!");
	        }
	    } 

	


