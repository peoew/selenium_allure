package framework.pages.base;

import framework.common.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//базовая старница, общие вещи, наследуемся от нее
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    //отвеает за явные ожидания
    public WebElement waitElementIsVisible(WebElement webElement) {
        //передаем элемент и ожидаем, пока он появится
        new WebDriverWait(driver, Config.IMPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(webElement));
        //возвращаем
        return webElement;
    }
}
