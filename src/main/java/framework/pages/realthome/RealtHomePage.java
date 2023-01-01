package framework.pages.realthome;

import framework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//наследумеся от BasePage
public class RealtHomePage extends BasePage {

    //создаем конструктор
    public RealtHomePage(WebDriver driver) {
        super(driver);
    }

    //Описываем локаторы
    By countRooms = By.xpath("//select[@id='rooms']");
    By option2rooms = By.xpath("//select[@id='rooms']/option[@value='2']");
    By findBtn = By.xpath("//div[@id='residentialInputs']//a[text()='Найти']");

    //метод делает шаги и возвращает полученное
    public RealtHomePage enterCountRooms() {
        driver.findElement(countRooms).click();
        driver.findElement(option2rooms).click();
        return this;
    }

    //метод делает шаги и возвращает полученное, лучше выносить в отдельный метод
    public RealtHomePage clickToFindBtn() {
        driver.findElement(findBtn).click();
        return this;
    }
    //enterCountRooms и clickToFindBtn ------> это резиновый паттерн
}
