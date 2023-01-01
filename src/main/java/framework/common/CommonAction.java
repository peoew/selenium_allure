package framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

//общая настройка для всего проекта - применяем паттерн singleton
public class CommonAction {
    //static, null
    private static WebDriver driver = null;

    //private, пустой
    private CommonAction() {
    }

    //public, static, возвращает драйвер
    public static WebDriver createDriver(){
        //singleton паттерн
        if (driver == null) {
            switch (Config.PLATFORM_AND_BROWSER) {
                case "win_chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "win_gecko":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    Assert.fail("Неккоректная платформа или браузер: " + Config.PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Config.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    };
}

