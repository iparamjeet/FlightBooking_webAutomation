package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyUrlPage {

	WebDriver driver;
	public VerifyUrlPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String returnURl() {
		String urlVal= driver.getCurrentUrl();
		return urlVal;
	}
}
