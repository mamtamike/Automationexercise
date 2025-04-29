package com.automationexercise.authentication;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automationexercise.util.BaseTest;
import com.automationexercise.util.ReadXlsData;

public class Signup extends BaseTest {
	@Test(dataProviderClass = ReadXlsData.class, dataProvider = "testdata")
	public void signupTest(String... userDetails) throws InterruptedException {
		String name = userDetails[0];
		String email = userDetails[1];
		String password = userDetails[2];
		String firstName= userDetails[3];
		String lastName= userDetails[4];
		String company = userDetails[5];
		String address1 = userDetails[6];
		String address2 = userDetails[7];
		String state = userDetails[8];
		String city = userDetails[9];
		String zipcode = userDetails[10];		
		String mobileNumber = userDetails[11];

		//System.out.println(userDetails);
	

		// signup link click on menu bar
		WebElement buttonEnable = driver.findElement(By.xpath(lc.getProperty("signup_link")));
		System.out.println("signup/login button enable: " + buttonEnable.isEnabled());
		WebElement button = driver.findElement(By.xpath(lc.getProperty("signup_link")));
		System.out.println("Text visible on menu bar is: " + button.getText());
		driver.findElement(By.xpath(lc.getProperty("signup_link"))).click();
		System.out.println("Tittle of window is: " + driver.getTitle());
		// name
		WebElement nameInput = driver.findElement(By.xpath(lc.getProperty("name_field")));
		System.out.println("nameplaceholder is: " + nameInput.getDomAttribute("placeholder"));
		driver.findElement(By.xpath(lc.getProperty("name_field"))).sendKeys(name);
		// email
		WebElement emailInput = driver.findElement(By.xpath(lc.getProperty("email_field")));
		System.out.println("emailplaceholder is: " + emailInput.getDomAttribute("placeholder"));
		driver.findElement(By.xpath(lc.getProperty("email_field"))).sendKeys(email);

		// signup button
		WebElement signupButton = driver.findElement(By.xpath(lc.getProperty("signup_button")));
		System.out.println("signup button is displayed: " + signupButton.isDisplayed());
		System.out.println("Text visible on button: " + signupButton.getText());
		driver.findElement(By.xpath(lc.getProperty("signup_button"))).click();

		// select gender
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[@type='radio' and @name='title']"));
		System.out.println(radiobuttons.size());
		for (int i = 0; i < radiobuttons.size(); i++) {
			radiobuttons.get(i).click();
			System.out.println("radio button is enabled: " + radiobuttons.get(i).isEnabled());
			radiobuttons.get(0).click();
		}
		// password field
		driver.findElement(By.xpath(lc.getProperty("pwd_field"))).sendKeys(password);

		// Select date
		WebElement datedropbox = driver.findElement(By.xpath("//*[@id='days']"));
		Select selectdate = new Select(datedropbox);
		selectdate.selectByIndex(18);
		List<WebElement> datelist = selectdate.getOptions();
		System.out.println(datelist.size());
		for (int i = 0; i < datelist.size(); i++) {
			System.out.println("dates are: " + datelist.get(i).getText());
		}
		
		// Select month
		WebElement monthdropbox = driver.findElement(By.xpath("//*[@id='months']"));
		Select selectmonth = new Select(monthdropbox);
		selectmonth.selectByVisibleText("January");

		List<WebElement> monthlist = selectmonth.getOptions();
		System.out.println(monthlist.size());
		for (int i = 0; i < monthlist.size(); i++) {
			System.out.println("months are: " + monthlist.get(i).getText());
		}
		
		// Select year
		WebElement yeardropbox = driver.findElement(By.xpath("//*[@id='years']"));
		Select selectyear = new Select(yeardropbox);
		selectyear.selectByValue("2000");
		List<WebElement> yearlist= selectyear.getOptions();
		System.out.println(yearlist.size());
		for (int i = 0; i < yearlist.size(); i++) {
			System.out.println("years are: " + yearlist.get(i).getText());
		}
		// checkbutton statements
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkbox.size());
		for (int i = 0; i < checkbox.size(); i++) {
			checkbox.get(i).click();
			System.out.println("radio button is enabled: " + radiobuttons.get(i).isEnabled());
			checkbox.get(i).click();
		
		 checkbox.get(0).click();
			// first name
			driver.findElement(By.xpath(lc.getProperty("first_name"))).sendKeys(firstName);
			Thread.sleep(2000);

			// last name
			driver.findElement(By.xpath(lc.getProperty("last_name"))).sendKeys(lastName);
			Thread.sleep(2000);

			// company
			driver.findElement(By.xpath(lc.getProperty("Company_name"))).sendKeys(company);
			Thread.sleep(2000);

			// address
			driver.findElement(By.xpath(lc.getProperty("Address1"))).sendKeys(address1);
			Thread.sleep(2000);

			// address2
			driver.findElement(By.xpath(lc.getProperty("Address2"))).sendKeys(address2);
			Thread.sleep(2000);

			
			//country
			WebElement countrydropbox = driver.findElement(By.xpath("//*[@id='country']"));
			Select selectcountry = new Select(countrydropbox);
			selectcountry.selectByVisibleText("India");
			List<WebElement> countrylist = selectcountry.getOptions();
			System.out.println(countrylist.size());
			for (int i1= 0; i1 < countrylist.size(); i1++) {
				System.out.println("dates are: " + countrylist.get(i1).getText());

			}
			Thread.sleep(2000);

			
			// state
			driver.findElement(By.xpath(lc.getProperty("State_field"))).sendKeys(state);
			Thread.sleep(2000);

			// city
			driver.findElement(By.xpath(lc.getProperty("City_field"))).sendKeys(city);
			Thread.sleep(2000);

			// zipcode
			driver.findElement(By.xpath(lc.getProperty("Zipcode_field"))).sendKeys(zipcode);
			Thread.sleep(2000);

			// mobile number
			driver.findElement(By.xpath(lc.getProperty("Mobile_Number"))).sendKeys(mobileNumber); 
			Thread.sleep(2000);

			//create account
			WebElement createButton = driver.findElement(By.xpath(lc.getProperty("create_account")));
			System.out.println("createaccount button is displayed: " + createButton.isDisplayed());
			System.out.println("Text visible on button: " + createButton.getText());
			driver.findElement(By.xpath(lc.getProperty("create_account"))).click();

		}

	}

}
