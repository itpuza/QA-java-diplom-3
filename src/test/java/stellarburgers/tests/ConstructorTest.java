package stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobjects.MainPage.URL;

public class ConstructorTest {

    //Тесты только для браузера гугл хром, т.к. яндекс браузер на маке с М1 не открывается (перепробовано всё)
    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Checking go between tabs")
    public void checkGoBetweenTabsTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        mainPage.checkTabs();
        assertTrue("Isn't buns tab", mainPage.isBunsTabText());
        assertTrue("Isn't fillings tab", mainPage.isFillingsTabText());
        assertTrue("Isn't sauces tab", mainPage.isSaucesTabText());
    }

}