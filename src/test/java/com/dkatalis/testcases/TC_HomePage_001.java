package com.dkatalis.testcases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;

public class TC_HomePage_001 extends TestBase {

	public String title = "Sample Store";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();

	}

//	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void homeTest() throws InterruptedException {

		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Sample Store"));
		HomePage hp = new HomePage(driver);
		hp.midtransPillowDisplay();
		hp.clickBuyNow();
		Thread.sleep(3000);
		hp.setUserName(fullName);//Start fill details in shopping carts
		hp.setUserEmail(email);
		hp.setUserPhone(phone);
		hp.setUserCity(city);
		hp.setUseraddress(address);
		hp.setUserPostalCode(postalcode);
		hp.clickCheckoutAndPopUP();

	}
}
