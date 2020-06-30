package com.dkatalis.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public String baseURL = "https://demo.midtrans.com/";
	public static WebDriver driver;
	public String fullName = "Mukesh Kumar";
	public String email = "mukeshkumar.439142@gmail.com";
	public String phone = "9886403206";
	public String city = "Bangalore";
	public String address = "338 5th cross 29th main BTM 2nd Stage";
	public String postalcode = "560076";
	public String card = "4811 1111 1111 1114";
	public String expiredate = "05/20";
	public String ccvnumber = "123";
	public String bankotp = "112233";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
