package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

	
	WebDriver driver;
	public FormPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyTotalCostAndSubmit() {
		
	String totalCost= driver.findElement(By.xpath("//p[contains(text(),'Total Cost: ')]")).getText();
	System.out.println("Total cost: " +totalCost);

	System.out.println(totalCost.formatted("xxx.xx"));	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
}
}
