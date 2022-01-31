package week5.day12;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class All extends BaClass {

@Test(description = "Edit",priority= 2, enabled=true)
		public  void edLead() throws InterruptedException {
		
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
	
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
			driver.findElement(By.name("submitButton")).click();
			//driver.close();
}

////Edit

@Test(description="CreateLead", priority= 1, enabled=true,groups= {"TestCases"})
public  void crLead() throws InterruptedException {

   
//  5. Click on Leads Button
  driver.findElement(By.linkText("Leads")).click();
  //  6. Click on create Lead Button
  driver.findElement(By.linkText("Create Lead")).click();
  //  7. Enter CompanyName using id Locator
  driver.findElement(By.xpath("//input[@class=\"inputBox\"]")).sendKeys("KAPPA");
  //  8. Enter FirstName using id Locator
  driver.findElement(By.id("createLeadForm_firstName")).sendKeys("DOSS");
  //  9. Enter LastName using id Locator
  driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
  Thread.sleep(5000);
//  10. Select value as Employee in Source Using SelectbyVisible text
 WebElement dd = driver.findElement(By.name("dataSourceId"));
 Select dropdown = new Select(dd);
 dropdown.selectByVisibleText("Employee");
 	   
// 15. Click on create Lead Button Using name Locator
driver.findElement(By.name("submitButton")).click();
	 // 16. Get the Title of the resulting Page
WebElement title = driver.findElement(By.xpath("//div[text()=\"View Lead\"]"));
System.out.println(title.getText());
 }
//CreateLead


@Test(description ="DeleteLead",priority= 3,enabled=true,groups= {"TestCases"})
public  void de() throws InterruptedException {

	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Delete")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
	//driver.close();
}
////////////delete


@Test(description ="duplicate",priority= 4,enabled=true,groups= {"TestCases"})
public void duLead() throws InterruptedException {
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Duplicate Lead")).click();
	driver.findElement(By.name("submitButton")).click();
}
////////////duplicate

@Test(description="Merge",priority= 5, enabled=false, invocationCount=2, threadPoolSize=2)
public  void me1() throws InterruptedException {
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Merge Leads")).click();
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
    Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	//driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("gopi");
//	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	String leadID = driver.findElement(By.xpath("//div/a[@class=\"linktext\"]")).getText();
	driver.findElement(By.xpath("//div/a[@class=\"linktext\"]")).click();
	driver.switchTo().window(allhandles.get(0));
	
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("babu");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
	//driver.close();
}

}
