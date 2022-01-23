package testng;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {
@Test
public  void createLead() throws InterruptedException {
		
	/*	//Setupfor browser and driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		 
		 // Enter UserName and Password Using Id Locator
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		 
		 // Click on Login Button using Class Locator
		 driver.findElement(By.className("decorativeSubmit")).click();
	 */
		 // Click on CRM/SFA Link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 
		 Thread.sleep(5000);
		  
		 // 5. Click on contacts Button
		 driver.findElement(By.linkText("Contacts")).click();
		 Thread.sleep(2000);
		 
		 // 6. Click on Create Contact
		 driver.findElement(By.linkText("Create Contact")).click();
		 Thread.sleep(2000);
		   
		 // 7. Enter FirstName Field Using id Locator
		 driver.findElement(By.id("firstNameField")).sendKeys("Doss");
		 
		 // 8. Enter LastName Field Using id Locator
		 driver.findElement(By.id("lastNameField")).sendKeys("D");
		  
		 // 9. Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("DD");
		 
	 // 10. Enter LastName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("SS");
		 
		 // 11. Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.id("createContactForm_departmentName")).sendKeys("JAVA 5.0");
		 
		 // 12. Enter Description Field Using any Locator of your choice 
		 driver.findElement(By.id("createContactForm_description")).sendKeys("Testing");
		 		 
		 // 13. Enter your email in the E-mail address Field using the locator of your choice
		 		 driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("doss@testleaf.com");
		       Thread.sleep(2000);
		 
		 // 14. Select State/Province as NewYork Using Visible Text
		       WebElement state = driver.findElement(By.xpath("//select[@name=\"generalStateProvinceGeoId\"]"));
				 Select newyork = new Select(state);
				 newyork.selectByVisibleText("New York");
		 
		 // 15. Click on Create Contact
		 driver.findElement(By.xpath("//input[@Class=\"smallSubmit\"]")).click();
		 
		 // 16. Click on edit button 
		 driver.findElement(By.linkText("Edit")).click();
		 
		 // 17. Clear the Description Field using .clear
		 WebElement clr = driver.findElement(By.xpath("//textarea[@id=\"updateContactForm_description\"]"));
		 clr.clear();
		 Thread.sleep(2000);
		 //* 18. Fill ImportantNote Field with Any text
		 driver.findElement(By.xpath("//textarea[@name=\"importantNote\"]")).sendKeys("SeleniumWEbDriver");
		  
		 //* 19. Click on update button using Xpath locator
		  driver.findElement(By.xpath("//input[@Class=\"smallSubmit\"]")).click();
		  
			//* 20. Get the Title of Resulting Page.
		WebElement title = driver.findElement(By.xpath("//div[text()=\"View Contact\"]"));
		String a=title.getText();
		System.out.println(a);
		 
		
	}

} 