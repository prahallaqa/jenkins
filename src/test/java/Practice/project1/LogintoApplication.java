package Practice.project1;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)
public class LogintoApplication extends BaseTest {
	@Test(retryAnalyzer = RetryLogic.class)
	public void withvalidcredentials() {
		LoginPage loginpage = new LoginPage(driver);

		WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(20));

WebElement loginId = wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.name("LoginId")
    )
);

loginId.sendKeys(username);

		
		//loginpage.EnterValidUsername();
		Reporter.log("Username entered successfully");
		loginpage.EnterValidPassword();
		Reporter.log("Password entered successfully");
		loginpage.ClickOnLoginButton();
		Reporter.log("LoginButton Clicked successfully");
	}
}
