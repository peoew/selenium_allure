package exaples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestVvodTextaFailov {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://images.google.com/");

        driver.findElement(By.xpath("//div[@class='nDcEnd']")).click();

        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("E:\\Загрузки\\1212368.jpg");
    }
}
