package iRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryDemo implements IRetryAnalyzer {

    int initial_Count = 0;
    int retry_count = 2; // Maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (initial_Count < retry_count) {
        	initial_Count++;
            return true; // Retry the test
        }
        return false; // Stop retrying after maxRetryCount
    }

}
