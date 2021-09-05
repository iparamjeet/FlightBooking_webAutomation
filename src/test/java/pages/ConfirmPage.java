package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By.ByXPath;

public class ConfirmPage {


	WebDriver driver;
	public ConfirmPage(WebDriver driver){
		this.driver = driver;
	}
	
	By succesHeading = new By.ByXPath("//h1[contains(text(),'Thank you for your purchase today!')]");
	By bookId =  new By.ByXPath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]");
	
	public void verifySuccessPage(String hdng) {
		String heading= driver.findElement(succesHeading).getText();
		Assert.assertEquals(heading, hdng);
	}
	
	public String getBookingID() {
		String idVaue = driver.findElement(bookId).getText();
		return idVaue;
	}
}
