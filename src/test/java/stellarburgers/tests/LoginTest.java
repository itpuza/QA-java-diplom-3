package stellarburgers.tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobjects.LoginPage;
import stellarburgers.pageobjects.MainPage;
import stellarburgers.pageobjects.PasswordRecoveryPage;
import stellarburgers.pageobjects.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static stellarburgers.pageobjects.MainPage.URL;
import static org.junit.Assert.assertTrue;

public class LoginTest {

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
    @DisplayName("Checking login on main page button")
    public void checkLoginByMainPageButtonTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        assertTrue("It's not create order page", mainPage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Checking login on person area button")
    public void checkLoginByPersonAreaButtonTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonAreaButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        assertTrue("It's not create order page", mainPage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Checking login on registration form button")
    public void checkLoginByRegistrationFormButtonTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        LoginPage loginPageRegistration = registrationPage.clickLoginButton();
        loginPageRegistration.login(credentials.get("email"), credentials.get("password"));
        assertTrue("It's not create order page", mainPage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Checking login on password recovery form button")
    public void checkLoginPasswordRecoveryFormButtonTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickPasswordRecoveryButton();
        LoginPage loginPagePassword = passwordRecoveryPage.clickRegistrationButton();
        loginPagePassword.login(credentials.get("email"), credentials.get("password"));
        assertTrue("It's not create order page", mainPage.isCreateOrderButton());
    }

}