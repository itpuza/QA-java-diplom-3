package stellarburgers.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //Локаторы регистрации
    //Поле имя
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;

    //Поле email
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    //Поле пароль
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    //Кнопка зарегистрироваться
    @FindBy(xpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;

    //Кнопка войти
    @FindBy(xpath = "//*[text()='Войти']")
    private SelenideElement loginButton;

    //Ошибка пароля
    @FindBy(xpath = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement errorMessage;

    //Методы для регистрации
    @Step("Set value in name field")
    public void setName(String name) {
        this.nameField.setValue(name);
    }

    @Step("Set value in email field")
    public void setEmail(String email) {
        this.emailField.setValue(email);
    }

    @Step("Set value in password field")
    public void setPassword(String password) {
        this.passwordField.setValue(password);
    }

    @Step("Click registration button")
    public void clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
    }

    @Step("Set values to registration form fields")
    public void registration(String name, String password, String email) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Check error message if password isn't corrected")
    public boolean isErrorMessage(String text) {
        errorMessage.shouldHave(exactText(text));
        return true;
    }

}