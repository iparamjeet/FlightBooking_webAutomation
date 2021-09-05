package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	By title = new By.ByXPath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
	By hyperLink = new By.ByXPath("//a[@href='vacation.html']");
	By fromSelect = new By.ByName("fromPort");
	By toSelect = new By.ByName("toPort");
	By searchFlight = new By.ByXPath("//input[@type='submit']");
	
	
	public String getHomePageTitle() {
		String titleVal = driver.findElement(title).getText();
		return titleVal;
	}
	
	public void clickOnLink() {
		driver.findElement(hyperLink).click();
	}
	
	public void findFlight(String fromDest, String toDest) {
		Select fr = new  Select(driver.findElement(fromSelect));
		fr.selectByValue(fromDest);

		Select to = new  Select(driver.findElement(toSelect));
		to.selectByValue(toDest);
		
		driver.findElement(searchFlight).click();
	}
	
}
