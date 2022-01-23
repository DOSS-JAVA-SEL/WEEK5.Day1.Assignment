package testng;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merge extends BaseClass{

@Test
	public void merge() throws InterruptedException {
	/*	//1.Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps/control/login");
				
				// 2	Enter the username
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("DemoSalesManager");
				
				// 3	Enter the password
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				// 4	Click Login
				driver.findElement(By.className("decorativeSubmit")).click();
				*/
				// 5	Click crm/sfa link
				 driver.findElement(By.linkText("CRM/SFA")).click();
				 
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("(//a/img[@alt=\"Lookup\"])[1]")).click();

	Thread.sleep(3000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());

		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class=\"linktext\"])[1]")).click();
		driver.switchTo().window(windows.get(0));

		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//a/img[@alt=\"Lookup\"])[2]")).click();

		Thread.sleep(3000);

		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//td[@class=\"x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first \"]//a[@class=\"linktext\"])[2]")).click();

		driver.switchTo().window(windows.get(0));

		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Accept the Alert
		driver.switchTo().alert().accept();

		// Verify the title of the page
		System.out.println(driver.getTitle());
		
		// 16 Close the browser (Do not log out)
		//  driver.close();
	}
}