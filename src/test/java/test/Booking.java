package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ConfirmPage;
import pages.FlightSearchResult;
import pages.FormPage;
import pages.HomePage;
import pages.VerifyUrlPage;

public class Booking {

	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
	}
	
	@Test(priority = 0)
	public void verifyPageTitle() {
		HomePage home = new HomePage(driver);
		String title = home.getHomePageTitle();
		System.out.println("Title of page is: " +title);
		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!");
	}
	
	@Test(priority = 1)
	public void verifyURlOfNewTab() {
		HomePage home = new HomePage(driver);
		home.clickOnLink();
		VerifyUrlPage newPage = new VerifyUrlPage(driver);
		String urlVal = newPage.returnURl();
		System.out.println(urlVal.contains("vacation")); //assert contains
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void bookMinimumPriceTicket() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.findFlight("Mexico City", "London");
		
		FlightSearchResult res = new FlightSearchResult(driver);
		res.searchMinAmountFlight();
		
		FormPage formpage = new FormPage(driver);
		formpage.verifyTotalCostAndSubmit();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void verifyAndGetBookId() {
		ConfirmPage confirm = new ConfirmPage(driver);
		confirm.verifySuccessPage("Thank you for your purchase today!");
		String id = confirm.getBookingID();
		System.out.println("Booking ID for lowest price: " +id);

	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
