package stellarburgers.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    //Кнопка выход
    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    private SelenideElement logoutButton;

    //Кнопка контруктор
    @FindBy(xpath = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    //Логотип
    @FindBy(xpath = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    @Step("Click logout button")
    public MainPage clickLogoutButton() {
        logoutButton.scrollTo();
        logoutButton.click();
        return Selenide.page(MainPage.class);
    }

    @Step("Click constructor button")
    public MainPage clickConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.click();
        return Selenide.page(MainPage.class);
    }

    @Step("Scroll to the logo and click on it")
    public MainPage clickLogo() {
        logo.scrollTo();
        logo.click();
        return Selenide.page(MainPage.class);
    }

}