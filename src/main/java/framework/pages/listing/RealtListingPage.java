package framework.pages.listing;

import framework.pages.base.BasePage;
import framework.pages.realthome.RealtHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//наследуемся от базовой-страницы
public class RealtListingPage extends BasePage {

    //используем конструктор
    public RealtListingPage(WebDriver driver) {
        super(driver);
    }

    //записываем путь карточки
    private final By card = By.xpath("//div[contains(@class,'highlighted')]");

    //метод проверяющий кол-во карточек
    public RealtListingPage checkCountCards() {
        //проверяем, что карточки действиетельно появились на странице
        waitElementIsVisible(driver.findElement(card));

        //записываем кол-во карточек в переменную (size)
        int countCard = driver.findElements(card).size();

        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals(countCard,20);

        //возвращаем страничку
        return this;
    }
}
