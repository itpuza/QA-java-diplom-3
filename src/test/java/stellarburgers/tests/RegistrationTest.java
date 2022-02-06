package stellarburgers.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;

import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobjects.MainPage.URL;

public class RegistrationTest {

    //Тесты только для браузера гугл хром, т.к. яндекс браузер на маке с М1 не открывается (перепробовано всё)
    String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
    String passwordSuccessful = RandomStringUtils.randomAlphabetic(10);
    String passwordUnsuccessful = RandomStringUtils.randomAlphabetic(5);
    String name = RandomStringUtils.randomAlphabetic(10);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Checking successful registration")
    public void checkSuccessfulRegistrationTest() {
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        registrationPage.registration(name, passwordSuccessful, email);
        assertTrue("It's not login page", loginPage.isLoginPage());
    }

    @Test
    @DisplayName("Checking error after registration with uncorrected password")
    public void checkUnsuccessfulRegistrationTest() {
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        registrationPage.registration(name, passwordUnsuccessful, email);
        assertTrue("It's not error message text", registrationPage.isErrorMessage("Некорректный пароль"));
    }

}