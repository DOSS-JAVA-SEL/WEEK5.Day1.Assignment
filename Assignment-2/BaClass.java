package week5.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaClass {
 
     public ChromeDriver driver;
     
   @BeforeMethod(alwaysRun=true)
	public  void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, minute);
		
		
		
	     WebElement userName = driver.findElement(By.id("username"));
	     userName.sendKeys("Demosalesmanager");
	
	      driver.findElement(By.id("password")).sendKeys("crmsfa");
	
	     driver.findElement(By.className("decorativeSubmit")).click();

	
	     driver.findElement(By.linkText("CRM/SFA")).click();
 	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod()  {

		driver.close();
	}


	}


