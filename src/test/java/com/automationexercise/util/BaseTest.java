package com.automationexercise.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Properties lc=new Properties();

	public static FileReader fr;
	public static FileReader fr1;

	

    @BeforeSuite
	public void setup() throws IOException {
    	if(driver==null) {
    	fr=new FileReader("C:\\eclipse_workspace\\TestAutomationExercise\\src\\test\\resources\\configfiles\\testdata.properties");
    	fr1=new FileReader("C:\\eclipse_workspace\\TestAutomationExercise\\src\\test\\resources\\configfiles\\locator.properties");

    	prop.load(fr);
    	lc.load(fr1);

    	}
    	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));
	    }
    	else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    		driver.manage().window().maximize();
    		driver.get(prop.getProperty("testurl"));
    	}
    	else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    		driver.manage().window().maximize();
    		driver.get(prop.getProperty("testurl"));
    		
    	}	
    }
    @AfterSuite
    public void tearDown() {
    	driver.close();
    }


	}





