package tests.searchappartaments;

import org.testng.annotations.DataProvider;

//класс для данных
public class DataProviderClass {

    //метод который возвращаем сами данные тестовые
    @DataProvider
    public Object[][] dataProviderMethod() {
            return new Object[][] {
                    {"1", "string"},
                    {"2", "string"},
                    {"3", "string"}
            };
    }
}
