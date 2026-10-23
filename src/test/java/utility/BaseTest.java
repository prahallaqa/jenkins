package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends ListenersLogic {
	

	@Parameters("nameofBrowser")
	@BeforeMethod
	public void launchbrowser(String nameofBrowser) {
		// Put this before Driver initialization to suppress WebSocket reset noise
		java.util.logging.Logger.getLogger("org.openqa.selenium.remote.http.WebSocket")
				.setLevel(java.util.logging.Level.OFF);
		if (nameofBrowser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (nameofBrowser.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (nameofBrowser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("https://192.168.2.200:543");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser Opened");
	}

	@AfterMethod
	public void quitbrowser() {
		driver.close();
		System.out.println("Browser Closed");
	}
}
