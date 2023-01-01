package tests.searchappartaments;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;
import tests.basetest.CustomListener;

@Listeners(CustomListener.class)
public class TestSOUT {

    @Test(invocationCount = 4,
            successPercentage = 50,
            dataProvider = "dataProviderMethod",
            dataProviderClass = DataProviderClass.class)
    public void testSoutConsole(String number, String string) {
        System.out.println("ЭТО ВТОРОЙ ТЕСТ !!! " + number + " " + string);
    }
}
