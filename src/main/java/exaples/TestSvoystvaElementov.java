package exaples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSvoystvaElementov {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");

        By imgPath = By.xpath("//img[@class='lnXdpd']");
        WebElement img = driver.findElement(imgPath);

        System.out.println(img.getAttribute("src"));

        String fact = img.getAttribute("src");
        String expected = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

        if (expected.equals(fact)) {
            System.out.println("PASS ✔️");
        } else System.out.println("FALL ❌");

    }
}
