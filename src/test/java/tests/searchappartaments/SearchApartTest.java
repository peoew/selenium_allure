package tests.searchappartaments;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;
import tests.basetest.CustomListener;

//наш тест-класс, наследуемся от базовго-теста
@Listeners(CustomListener.class)
public class SearchApartTest extends BaseTest {

    //сам тест
    @Test
    public void checkIsRedirectToListing() {

        //открываем страничку
        basePage.open("https://realt.by");

        //меняем окно
        switchWindow();

        //открываем страничку
        basePage.open("https://realt.by");

        //применяем методы
        realtHomePage.enterCountRooms().clickToFindBtn();

        //метод по подсчету карточек
        realtListingPage.checkCountCards();
    }

}

