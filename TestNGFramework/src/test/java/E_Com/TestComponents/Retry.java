package E_Com.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	// Used to retry failed test case again just to check the failure is genuine.

	int count = 0;
	int maxTry = 2;

	@Override
	public boolean retry(ITestResult arg0) {
		if (count < maxTry) {
			count++;
			return true;
		}
		return false;
	}
}
