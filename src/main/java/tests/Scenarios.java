package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenarios {
	
	
	
	

//Send correct info test	
public void SendCorrectInfo(WebDriver driver) {
		
		System.out.println("Send correct information test executed...");
		
		//Navigating herolto 
		driver.get("https://automation.herolo.co.il/");
		
		//Wait untill title is found.
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/label/span")));
		
		
		
		try {
			//Inserting Name to name input
		driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys("Yonatan Hornstein");
		
		}
		catch (Exception e) {
			System.out.println("Name input not found");
			e.printStackTrace();
		}
		
		try {
			//Inserting email to email input
			driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("yonatanhornstein+"+(int)Math.random()*1000+"@gmail.com");
			}
			catch (Exception e) {
				System.out.println("email input not found");
				e.printStackTrace();
			}
		
		try {
			//Inserting phone to phone input
			driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys("0508877780");
			}
			catch (Exception e) {
				System.out.println("phone input not found");
				e.printStackTrace();
			}
		
		try {
			//Clicking send button.     
			driver.findElement(By.xpath("//*[@id=\"footer\"]/form/button")).click();
			}
			catch (Exception e) {
				System.out.println("button input not found");
				e.printStackTrace();
			}
		
		//waiting for text to be visiable
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div[1]/div[2]/h1/span")));
		
		
		
		System.out.println("Verifying text...");
		
		//Fetching thank you title as string.
		String thankYou_TitleStr = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div[1]/div[2]/h1/span")).getText();
		
		//if Thank you title is equal, test is passed, else, not.
		if(thankYou_TitleStr.equals("תודה!")) {
			System.out.println("Send information test - PASSED");
		}
		else {
			System.out.println("Send information test - FAILED");
		}
		
	}

public void SendInCorrectInfo(WebDriver driver) {
	
	System.out.println("Send incorrect information test executed...");
	
	//Navigating herolto 
	driver.get("https://automation.herolo.co.il/");
	
	//waiting untill footer is visiable.
	WebDriverWait wait = new WebDriverWait(driver,240);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/label/span")));
	
	
	
	try {
		//Inserting name into name input
	driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys("Yonatan Hornstein");
	
	}
	catch (Exception e) {
		System.out.println("Name input not found");
		e.printStackTrace();
	}
	
	try {
		//Inserting incorrecet email.
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("yonatanhornst3cseailbqm");
		}
		catch (Exception e) {
			System.out.println("email input not found");
			e.printStackTrace();
		}
	
	try {
		//wait untill error message is present.
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/form/div/div[2]/label/span")));
		
		String emailInputErrorStr = driver.findElement(By.xpath("//*[@id=\"footer\"]/form/div/div[2]/label/span")).getText();
		
		//if error message is equal then test PASSED, else, not.
        if(emailInputErrorStr.equals("כתובת אימייל לא חוקית")) {
        	System.out.println("Email error message - PASSED");
        }
        else {
        	System.out.println("Email error message - FAILED");
        }
		
		}
		catch (Exception e) {
			System.out.println("Email error message  not found");
		}
	
	try {
		//Inserting incorrect phone number
		driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys("bdd");
		}
		catch (Exception e) {
			System.out.println("phone input not found");
			e.printStackTrace();
		}
		
	
		
		

	
	try {
		//Clicking send 
		driver.findElement(By.xpath("//*[@id=\"footer\"]/form/button")).click();
		}
		catch (Exception e) {
			System.out.println("button input not found");
			e.printStackTrace();
		}
	
	try {
		//Waiting untill error message is visiable.
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/footer/form/div/div[3]/label/span")));
		
		
		//Fetching phone error message to a string.
		String phoneInputErrorStr = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/footer/form/div/div[3]/label/span")).getText();
		
		
		//If equal, then passed, else, failed.
        if(phoneInputErrorStr.equals("מספר טלפון לא חוקי")) {
        	System.out.println("Phone error message - PASSED");
        }
        else {
        	System.out.println("Phone error message - FAILED");
        }
		
		}
		catch (Exception e) {
			System.out.println("Phone error message  not found");
		}
}

public void SendEmptyInfo(WebDriver driver) {
	
	System.out.println("Send missing infomration test executed...");
	
	//Navigating herolto o 
	driver.get("https://automation.herolo.co.il/");
	
	//Waiting for footer to be visiable. 
	WebDriverWait wait = new WebDriverWait(driver,240);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/label/span")));
	
	
	
	try {
		//inserting name to name input
	driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys("Yonatan Hornstein");
	
	}
	catch (Exception e) {
		System.out.println("Name input not found");
		e.printStackTrace();
	}
	
	try {
		//inserting phone to phone input
		driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys("0508877780");
		}
		catch (Exception e) {
			System.out.println("email input not found");
			e.printStackTrace();
		}
	
	try {
		//click send
		driver.findElement(By.xpath("//*[@id=\"footer\"]/form/button")).click();
		}
		catch (Exception e) {
			System.out.println("button input not found");
			e.printStackTrace();
		}
	

	
	try {
		//waiting for error message.
	WebDriverWait wait1 = new WebDriverWait(driver,30);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/form/div/div[2]/label/span")));
	
	System.out.println("Send with no email  - PASSED");
	}
	catch (Exception e) {
		System.out.println("Send with no email  - FAILED");
	}
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	//Clear phone input *Using keys, i found a problem in site with .clear
	driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys(Keys.CONTROL + "a");
	driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys(Keys.DELETE);
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		//inserting email to email input.
		driver.findElement(By.xpath("//*[@id=\"footer\"]/form/div/div[2]/input")).sendKeys("yonatanhornstein@gmail.com");
		}
		catch (Exception e) {
			System.out.println("email input not found");
			e.printStackTrace();
		}
	

	try {
		//Click send
		driver.findElement(By.xpath("//*[@id=\"footer\"]/form/button")).click();
		}
		catch (Exception e) {
			System.out.println("button input not found");
			e.printStackTrace();
		}
	
	try {
		//Wait for error message.
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/form/div/div[3]/label/span")));
		
		//If found, test PASSED
		System.out.println("Send with no phone  - PASSED");
		}
		catch (Exception e) {
			System.out.println("Send with no phone  - FAILED");
		}

}}
