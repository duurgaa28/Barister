package Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int retrycount = 0;
	int maxcount = 3;

	public boolean retry(ITestResult result) {
		if (retrycount < maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
