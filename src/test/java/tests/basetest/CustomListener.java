package tests.basetest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String text = iTestResult.getName();
        System.out.println(text + " START");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " FAIL");
        String methodName = iTestResult.getName();
        theScreenShot(methodName);
    }

    //метод для сделки скриншота
    public void theScreenShot(String methodName) {
            try {
                Robot robot = new Robot();
                BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(screenShot, "JPG", new File(methodName +".jpg"));
            } catch (AWTException | IOException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
