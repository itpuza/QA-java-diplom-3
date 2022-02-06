package stellarburgers.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage {

    //Кнопка войти
    @FindBy(xpath = "//*[text()='Войти']")
    private SelenideElement loginButton;

    //Метод клика по кнопке Зарегистрироваться
    @Step("Click registration button")
    public LoginPage clickRegistrationButton() {
        loginButton.scrollTo();
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

}