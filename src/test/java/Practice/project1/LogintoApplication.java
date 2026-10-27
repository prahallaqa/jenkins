
package Practice.project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        // Enter the username configured in your test data.
        loginId.sendKeys("YOUR_USERNAME");

        Reporter.log("Username entered successfully");

        loginpage.EnterValidPassword();
        Reporter.log("Password entered successfully");

        loginpage.ClickOnLoginButton();
        Reporter.log("Login button clicked successfully");
    }
}
