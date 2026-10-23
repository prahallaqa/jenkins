package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	 int initialCount = 0;
	 int maxRetryCount = 2; // Will retry 2 times (Total 3 executions)

	@Override
	public boolean retry(ITestResult result) {
		if (initialCount < maxRetryCount) {
			initialCount++;
			return true; // Tells TestNG to retry the test
		}
		return false; // Stops retrying
	}
}
