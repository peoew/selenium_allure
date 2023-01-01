package tests.basetest;

import framework.common.CommonAction;
import framework.pages.base.BasePage;
import framework.pages.listing.RealtListingPage;
import framework.pages.realthome.RealtHomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.util.Set;

public class BaseTest {
    //protected, создание драйвера, через метод
    protected WebDriver driver = CommonAction.createDriver();

    //protected, создаем базовую страничку, кладем созданный ввыше драйвер
    protected BasePage basePage = new BasePage(driver);

    //protected, создаем страничку, кладем созданный драйвер
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);

    //protected, создаем страничку, кладем созданный драйвер
    protected RealtListingPage realtListingPage = new RealtListingPage(driver);

    //после каждого прогона сьюита, закрывам окна
    @AfterSuite(alwaysRun = true)
    public void quite() {
        driver.quit();
    }

    //перемнная для алертов (явное ожидане)
    WebDriverWait wait = new WebDriverWait(driver, 10);

    //метод для взаимодействия с алертом
    protected void alertsAccept() {

        //дожидаемся, что алерт появился
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //переключаемся на алерт, для дальнейшего взаимодействия с ним
        driver.switchTo().alert();

        //взаимодействуем с алертом (принять)
        alert.accept();
    }

    //метод для смены окна
    protected void switchWindow() {

        //при помощи js делается
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //получаем хэш код окна текущего
        String window1 = driver.getWindowHandle();

        //метод из js для открытия окна
        js.executeScript("window.open()");

        //получаем хэш коды всех окон и сохраняем их в Set
        /*
        В множествах Set каждый элемент хранится только в одном экземпляре,
        а разные реализации Set используют разный порядок хранения элементов
         */
        Set<String> currentWindows = driver.getWindowHandles();

        //нужна перемнная куда поместим хэш код 2й страницы
        String window2 = null;

        //текущее окно не равно первому окну
        for(String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }

        //переходим на окно
        driver.switchTo().window(window2);
    }

}
