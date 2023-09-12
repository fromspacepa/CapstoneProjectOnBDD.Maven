package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;//This is the instance for WebDriver.
	public static Properties properties;//This is the instance for Properties to read our properties file, and you import this from java.util
	public static Logger logger;//This is imported from or.apache.log4j
	//Here following we are creating and initializing a private String to stored the "properties.properties" file path, which is in this project or at this project's level.
	//and it is going to be access only in this "Base" class since we created it as a private.
	private String propertyPath = ".\\src\\test\\resources\\input\\properties.properties";
	//Here following we are creating and initializing a private String to stored the "log4j" file path, which is in this project or at this project's level.
	//and it is going to be access only in this "Base" class since we created it as a private.
	private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";
	
	
	//Here following we are creating a constructor to initialize variable since they are in the class level.
	//NOTE: If we are creating a constructor, it should be named the same as class.
	
	@SuppressWarnings("static-access")//This is added/imported by the method below after we invoked the "logger = logger.getLogger("logger_File")" below.
	public Base() {
		//Here we are going to write a method to read the data from "properties.proprerties" file, which is located in this project.
		//NOTE: In the ".properties file" we have the URL for a Web-page and the browser such as "chrome" 
		try {
			//Here we are creating BufferedReader class object in order to be able read the data from properties file
			BufferedReader reader = new BufferedReader (new FileReader(propertyPath));
			//Here we are creating an object of .properties class
			properties = new Properties();
			//Here we are loading the .properties file to be read it
			properties.load(reader);
			//Here we are throwing the catch for "FileNotFoundException"
		} catch (FileNotFoundException e) {
			e.printStackTrace();//This is going to print the message for Exception
			//Here we are throwing the catch for "IOException"
		} catch (IOException e) {
			e.printStackTrace();//This is going to print the message for Exception	
		}
		//Here we are going to invoke the "Logger"
		logger = logger.getLogger("logger_File");
		//Here we are going to configure our log4j file and pass the path for log4j file in the parameter.
		PropertyConfigurator.configure(log4jPath);	
	}
	//This method is going to return/call the Url of a Web-page for us, which is in the ".properties" file
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	//this method will return the browser for us
		public static String getBrowser() {
			String browser = properties.getProperty("browser");
			return browser;
		}
		//we need to write a method to launch the browser
		public static void openBrowser() {
			driver.get(getUrl());
		}
		//this method will close/quit browser(s) for us
		public static void tearDown() {
			driver.close();
			driver.quit();
		}
		
		//we will use webdrivermanager so that we don't have to download webdriver for all browsers
		public static void browser() {
			
			String browserName = getBrowser();
			
			switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();//This method is going maximize the window of a web-page
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//This method is going to give wait time for the web-page to load before throwing exception.
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();//This method is going to delete all the cookies
		}

	}
