package exaples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestOsobennostiPoluchenuyaTexta {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://javastudy.ru/spring-data-jpa/annotation-persistence/");

        By path = By.xpath("//div[@class='entry-body']/p");

        WebElement search = driver.findElement(path);

        String str = search.getText();

        System.out.println(str);

    }
}
