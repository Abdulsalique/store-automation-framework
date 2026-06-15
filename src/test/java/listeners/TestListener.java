package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.getInstance()
                .createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getInstance()
                .createTest(result.getName())
                .log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getInstance()
                .createTest(result.getName())
                .log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
