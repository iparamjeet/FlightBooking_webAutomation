package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightSearchResult {

	WebDriver driver;
	public FlightSearchResult(WebDriver driver){
		this.driver = driver;
	}
	
	By totalResult =  new By.ByXPath("//table[@class='table']//tbody/tr");
	
	
	public void searchMinAmountFlight() {
		List<WebElement> ls = driver.findElements(totalResult);
		System.out.println("Total flightResult is : " +ls.size());
		
		ArrayList<String> price = new ArrayList<String>();
		for(int i =1; i<=ls.size(); i++) {
			price.add(driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+i+"]/td[6]")).getText());
		}
		
		Collections.sort(price);
		String minPrice = price.get(0);
		
		driver.findElement(By.xpath("//td[contains(text(),'"+minPrice+"')]/preceding-sibling::td/input")).click();
		
	
	}
}
