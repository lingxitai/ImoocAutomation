package cn.leon.login;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.IOException;

public class TestNgListener  extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult var1) {
        super.onTestSuccess(var1);
        System.out.println("监听，测试成功");
    }
    @Override
    public void onTestFailure(ITestResult var1) {
        super.onTestFailure(var1);
        TakeScreenShot ts = new TakeScreenShot();
        try {
            ts.takePicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("监听，测试失败");

    }
    @Override
    public void onTestStart(ITestResult var1) {
        super.onTestStart(var1);
        System.out.println("监听，测试开始onteststart");
    }
    @Override
    public void onStart(ITestContext var1) {
        super.onStart(var1);
        System.out.println("监听，测试开始onstart");
    }
    @Override
    public void onFinish(ITestContext var1) {
        super.onFinish(var1);
        System.out.println("监听，测试结束");
    }


    @Override
    public void onTestSkipped(ITestResult var1) {
        super.onTestSkipped(var1);
        System.out.println("监听，测试跳过");
    }
}
