package stellarburgers.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //Кнопка войти в аккаунт
    @FindBy(xpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement loginButton;

    //Кнопка оформить заказ
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //Кнопка личный кабинет
    @FindBy(xpath = "//*[text()='Личный Кабинет']")
    private SelenideElement personAreaButton;

    //Кнопка начинки
    @FindBy(xpath = "//*[text()='Начинки']")
    private SelenideElement fillingsButton;

    //Кнопка вкладки начинки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingsTab;

    //Кнопка соусы
    @FindBy(xpath = "//*[text()='Соусы']")
    private SelenideElement saucesButton;

    //Кнопка вкладки соусы
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesTab;

    //Кнопка булки
    @FindBy(xpath = ".//*[//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span]")
    private SelenideElement bunsButton;

    //Кнопка вкладки булки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsTab;

    //Методы для главной страницы
    @Step("Click login button")
    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Click button in person area page")
    public LoginPage clickPersonAreaButton() {
        personAreaButton.scrollTo();
        personAreaButton.click();
        return page(LoginPage.class);
    }

    @Step("Click profile button")
    public ProfilePage clickProfileButton() {
        personAreaButton.scrollTo();
        personAreaButton.click();
        return page(ProfilePage.class);
    }

    @Step("Check order button exist")
    public boolean isCreateOrderButton() {
        createOrderButton.shouldBe(visible, enabled);
        return true;
    }

    @Step("Click fillings button")
    public void clickFillingsButton() {
        fillingsButton.scrollTo();
        fillingsButton.click();
    }

    @Step("Check fillings tab exact text 'Начинки'")
    public boolean isFillingsTabText() {
        fillingsTab.shouldHave(exactText("Начинки"));
        return true;
    }

    @Step("Click sauces button")
    public void clickSaucesButton() {
        saucesButton.scrollTo();
        saucesButton.click();
    }

    @Step("Check sauces tab exact text 'Соусы'")
    public boolean isSaucesTabText() {
        saucesTab.shouldHave(exactText("Соусы"));
        return true;
    }

    @Step("Click buns button")
    public void clickBunsButton() {
        bunsButton.scrollTo();
        bunsButton.click();
    }

    @Step("Check buns tab exact text 'Булки'")
    public boolean isBunsTabText() {
        bunsTab.shouldHave(exactText("Булки"));
        return true;
    }

    @Step("Check can go between tabs")
    public void checkTabs() {
        clickFillingsButton();
        isFillingsTabText();
        clickSaucesButton();
        isSaucesTabText();
        clickBunsButton();
        isBunsTabText();
    }

}