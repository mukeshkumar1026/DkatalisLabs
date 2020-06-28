package com.dkatalis.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver ldriver;
	WebDriver driver;
	public String title = "Sample Store";

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "[class=\"title\"]")
	// @FindBy(xpath =
	// "//*[@id=\\\"container\\\"]/div/div/div[1]/div[2]/div/div/div[1]")
	@CacheLookup
	WebElement midtransPillow;

	@FindBy(css = "[class=\"btn buy\"]")
	// @FindBy(xpath = "//*[@id=\\\"container\\\"]/div/div/div[1]/div[2]/div/div/a")
	@CacheLookup
	WebElement clickBuyNow;

	// Name
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[1]/td[2]/input")
	WebElement inputName;

	// Email
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[2]/td[2]/input")
	WebElement inputEmail;

	// Phone Number
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[3]/td[2]/input")
	WebElement inputMobileNumber;

	// City
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[4]/td[2]/input")
	WebElement inputCity;

	// Address
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[5]/td[2]/textarea")
	WebElement inputAddress;

	// PinCode
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[6]/td[2]/input")
	WebElement inputPinCode;

	// Click CHECKOUT
	@FindBy(css = "[class=\"cart-checkout\"]")
	WebElement checkOut;

	// Click Continue

	@FindBy(css = "[class=\"text-button-main\"]")

	WebElement clickContinue;

	// Select credit card payment

	@FindBy(css = "[class=\"list-content\"]")

	WebElement selectCreditCard;

	// credit card number

	@FindBy(name = "cardnumber")
	WebElement inputcardNumber;

	// expire date

	@FindBy(xpath = "//*[@id=\"application\"]/div[3]/div/div/div/form/div[2]/div[2]/input")

	WebElement inputexpireDate;

	// cvv number

	@FindBy(xpath = "//*[@id=\"application\"]/div[3]/div/div/div/form/div[2]/div[3]/input")

	WebElement inputcvvNumber;

	// OTP

	// Browser Maximize

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	// Verify the midtransPillow is displayed or not
	public void midtransPillowDisplay() {
		if (midtransPillow.isDisplayed()) {
			System.out.println("Image is display");
			// Verify the image text value
			System.out.println("The image text is " + midtransPillow.getAttribute("alt"));
		} else {
			System.out.println("Image is not display");
		}
	}

	// Verify title

	public void verifyhomePageTitle() {
		if (driver.getTitle().contains(title)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	// BuyNow
	public void clickBuyNow() {
		if (clickBuyNow.isEnabled()) {
			System.out.println("BuyNow Image enable");
			// Click BuyNow
			clickBuyNow.click();
			System.out.println("BuyNow Image is clicked");
		} else {
			System.out.println("BuyNow in image Button is not enable");
		}
	}

	// Enter Full Name

	public void setUserName(String fullName) {
		inputName.clear();
		inputName.sendKeys(fullName);
	}

	// Enter Email

	public void setUserEmail(String email) {
		inputEmail.clear();
		inputEmail.sendKeys(email);
	}
	// Enter phone

	public void setUserPhone(String phone) {
		inputMobileNumber.clear();
		inputMobileNumber.sendKeys(phone);
	}
	// Enter city

	public void setUserCity(String city) {
		inputCity.clear();
		inputCity.sendKeys(city);
	}

	// Enter address

	public void setUseraddress(String address) {
		inputAddress.clear();
		inputAddress.sendKeys(address);
	}

	// Enter postal code

	public void setUserPostalCode(String postalcode) {
		inputPinCode.clear();
		inputPinCode.sendKeys(postalcode);
	}

	public void setUserCreditCard(String card) {
		inputcardNumber.clear();
		inputcardNumber.sendKeys(card);
	}

	public void setUserExpireDate(String expiredate) {
		inputexpireDate.clear();
		inputexpireDate.sendKeys(expiredate);

	}

	public void setUserCVVNumber(String ccvnumber) {
		inputcvvNumber.clear();
		inputcvvNumber.sendKeys(ccvnumber);
	}

//		public void setUserBankOTP(String bankotp) {
//			
//			
//			
//		}
	// Click check out

	public void clickCheckoutAndPopUP() throws InterruptedException {

		checkOut.click();
		Thread.sleep(3000);
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.cssSelector("clickContinue")).click();
				driver.findElement(By.cssSelector("selectCreditCard")).click();
				driver.findElement(By.name("cardnumber")).sendKeys("4811 1111 1111 1114");
				driver.findElement(By.xpath("//*[@id=\\\"application\\\"]/div[3]/div/div/div/form/div[2]/div[2]/input"))
						.sendKeys("05/20");
				driver.findElement(By.xpath("//*[@id=\\\"application\\\"]/div[3]/div/div/div/form/div[2]/div[3]/input"))
						.sendKeys("123");
				driver.findElement(By
						.xpath("//*[@id=\\\"container\\\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[2]/td[2]/input"))
						.sendKeys("mukeshkumar.439142@gmail.com");
				driver.findElement(By
						.xpath("//*[@id=\\\"container\\\"]/div/div/div[2]/div[1]/div[4]/table/tbody/tr[3]/td[2]/input"))
						.sendKeys("9886403206");
				driver.findElement(By.xpath("//*[@id=\"application\"]/div[1]/a/div[1]/span")).click();
			}
		}
	}
}
