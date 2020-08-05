package threadResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.swing.event.TreeWillExpandListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tests.Scenarios;



public class myThread implements Runnable  {

	
	private String testName;
	private String browser;
	private String name;
	private WebDriver driver;
	private int times;

	public myThread(String name,String testName,int times, String browser ) {
		this.name=name;
		this.browser=browser;
		this.testName = testName;
		this.times = times;
	
		
		
	}
	
	

	@Override
	public void run() {
		
		//Num of time the user want to run the test
		int timess=times;	
		
			//For loop to iterate over the number of times the user want to run the test.
			for (int i = 0; i < timess; i++) {
				//init WebDriver object
				WebDriver driver1=null;
				
			//If user chose to test on chrome browser
			if(browser.equals("chrome")) {
				//init Chrome option object to use with the webDriver.
				ChromeOptions options = new ChromeOptions();
				//Path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\yonat\\Documents\\STS[rojects\\Work//chromedriver.exe");
				//Enable the option to ignore certificate errors
				options.addArguments("--ignore-certificate-errors");
				//Populating webDriver with ChromeDriver object with chromeOptions
				driver1 = new ChromeDriver(options);
				//Enable fullscreen
				driver1.manage().window().fullscreen();
				
			}
			//if user chose to test on firefox browser.
			if(browser.equals("firefox")){
				System.setProperty("webdriver.gecko.driver","C:\\Users\\yonat\\Documents\\STS[rojects\\Work//geckodriver.exe");
				
				
				driver1 = new FirefoxDriver();
			}
			if(browser.equals("safari")) {
				System.setProperty("webdriver.safari.driver", "/Users/user/Downloads/SafariDriver.safariextz⁩");
				
				driver1 = new FirefoxDriver();
			}
		    
			//Printing thread number
			System.out.println("Thread "+name+"  is Running! executing test -"+testName );
			
			
			//Creating scenarios object, which has all the tests scenarios
			Scenarios test = new Scenarios();
			
			//switch case 
			switch(testName.toString()) {
			
			case"SendCorrectInfo":{
				//First Test
				test.SendCorrectInfo(driver1);
				break;
			}
			case"SendInCorrectInfo":{
				//Second test
				test.SendInCorrectInfo(driver1);
				
				break;
			}
			case"SendEmptyInfo":{
				//Third test
				test.SendEmptyInfo(driver1);
				break;
			}
			
			
			
			}
				}}}
			