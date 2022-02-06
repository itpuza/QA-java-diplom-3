package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //Кнопка зарегистрироваться
    @FindBy(xpath = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    //Вход после регистрации
    @FindBy(xpath = ".//*[@class='Auth_login__3hAey']")
    private SelenideElement loginPage;

    //Поле email
    @FindBy(xpath =  "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement email;

    //Поле пароль
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement password;

    //Кнопка войти
    @FindBy(xpath = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    //Кнопка восстановить пароль
    @FindBy(xpath = "//*[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordButton;

    //Методы для авторизации
    @Step("Click registration button")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Check go to login page")
    public boolean isLoginPage() {
        loginPage.shouldBe(visible);
        return true;
    }

    @Step("Set value in email field")
    public void setEmail(String email) {
        this.email.setValue(email);
    }

    @Step("Set value in password field")
    public void setPassword(String password) {
        this.password.setValue(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
    }

    @Step("Click button on password recovery page")
    public PasswordRecoveryPage clickPasswordRecoveryButton() {
        recoveryPasswordButton.scrollTo();
        recoveryPasswordButton.click();
        return page(PasswordRecoveryPage.class);
    }

    @Step("Set value in login fields and click login button")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

}