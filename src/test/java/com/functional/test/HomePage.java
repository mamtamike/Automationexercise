package com.functional.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;

public class HomePage extends BaseTest {
    
 
    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String expectedTitle = "Automation Exercise"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title mismatch!");
    }

    @Test(priority = 2)
    public void verifyLogoPresence() {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        Assert.assertTrue(logo.isDisplayed(), "logo is not visible!");

    }
    @Test(priority=3)
    public void verifyNavigationBar() {
    	  List<WebElement> navbarBtn = driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a"));
    	  System.out.println("navbar buttons size: "+navbarBtn.size());
         for(int i=0; i<navbarBtn.size(); i++) {
        	 System.out.println("navbar all buttons text: "+navbarBtn.get(i).getText());
      }
    }
    @Test(priority = 4)
    public void verifyLoginButton() {
        WebElement loginBtn = driver.findElement(By.xpath(lc.getProperty("login_link")));
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is missing!");
        Assert.assertTrue(loginBtn.isEnabled(), "Login button is not enabled!");
    }
   
    @Test(priority=5)
    public void verifyProductButton() {
    	  WebElement productBtn = driver.findElement(By.xpath(lc.getProperty("product_button")));
          Assert.assertTrue(productBtn.isDisplayed(), "product button is missing!");
          Assert.assertTrue(productBtn.isEnabled(), "product button is not enabled!");
          
    }
    @Test(priority=6)
    public void verifyCartButton() {
    	WebElement productBtn = driver.findElement(By.xpath(lc.getProperty("cart_button")));
        Assert.assertTrue(productBtn.isDisplayed(), "cart button is missing!");
        Assert.assertTrue(productBtn.isEnabled(), "cart button is not enabled!");	
    }
    @Test(priority=7)
    public void verifyContactusButton() {
    	WebElement productBtn = driver.findElement(By.xpath(lc.getProperty("contact_button")));
        Assert.assertTrue(productBtn.isDisplayed(), "contact button is missing!");
        Assert.assertTrue(productBtn.isEnabled(), "contact button is not enabled!");	
    }
    @Test(priority=8)
    public void verifySubscription() {
    	try {
   
    	WebElement emailInput = driver.findElement(By.xpath(lc.getProperty("footer_email")));
		System.out.println("emailplaceholder is: " + emailInput.getDomAttribute("placeholder"));
		driver.findElement(By.xpath(lc.getProperty("footer_email"))).sendKeys("test.data@yopmail.com");
		WebElement buttonTest=driver.findElement(By.xpath("//*[@id=\"subscribe\"]/i"));
		buttonTest.click();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'success-subscribe']"))); 
        Assert.assertEquals(messageElement.getText(),"You have been successfully subscribed!");
    }
    	catch(Exception e) {
            e.printStackTrace();
        }
    }
    	@Test(priority=9)
    	public void verifyScrolldownScrollup() {
    		try {
    	 	    driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).click();//click home button

                JavascriptExecutor js = (JavascriptExecutor) driver;
                
                // Scroll down by 1000 pixels
                js.executeScript("window.scrollBy(0,10000)");
                Thread.sleep(2000); // Wait to observe the scroll
                
                // Scroll up without using arrow buttons (by 1000 pixels)
                js.executeScript("window.scrollBy(0,-10000)");
                Thread.sleep(2000); // Wait to observe the scroll
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
	 @Test(priority=10)
 	public void verifyBannerScroll() {
 		driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/a[2]/i")).click(); //click banner forward arrow
 		driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/a[1]/i")).click(); //click banner backward arrow

 		}
 	
    	@Test(priority=11)
    	public void verifyScrolldownToElement() {
    		WebElement product=driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[11]/div/div[1]/div[2]"));
    		Actions action=new Actions(driver);
    		action.scrollToElement(product).perform();  
    		}
   
    }
    
    