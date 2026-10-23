package Practice.project1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;// using this we can write synchronization concept

	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	// Step1
	@FindBy(name = "LoginId")
	WebElement Username;

	@FindBy(name = "Password")
	WebElement Password;

	@FindBy(xpath = "//span[text()='Submit']")
	WebElement Loginbutton;

// Step2:
	public void EnterValidUsername() {
		wait.until(ExpectedConditions.visibilityOf(Username));
		Username.sendKeys("admin");

	}

	public void EnterValidPassword() {
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.sendKeys("Gswpt@yqt456HgT");
	}

	public void ClickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(Loginbutton));
		Loginbutton.click();
	}

//Step 3
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);// initilize mu elements, this keyword method parameters and global
												// variable is same
	}
}
