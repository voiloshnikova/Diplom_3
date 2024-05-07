package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginButtonsAtPage {

    private final WebDriver driver;

    public LoginButtonsAtPage(WebDriver driver) {  // конструктор класса
        this.driver = driver;
    }

    private By loginInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
    private By registrationLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private By registrationLoginButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");
    private By restorePasswordButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    private By restoreLoginButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");
    private By fieldEmail = By.xpath("//fieldset[1]/div/div/input");
    private By fieldPassword = By.xpath("//fieldset[2]/div/div/input");
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By loginForm = By.xpath(".//h2[text()='Вход']");
    private By header = By.className("AppHeader_header__logo__2D0X2");

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickLoginInAccountButton() {
        driver.findElement(loginInAccountButton).click();
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на ссылку 'Зарегистрироваться'")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Нажать на кнопку 'Войти' в форме регистрации")
    public void clickRegistrationLoginButton() {
        driver.findElement(registrationLoginButton).click();
    }

    @Step("Нажать на кнопку 'Восстановить пароль'")
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step("Нажать на кнопку 'Войти' в форме восстановления пароля")
    public void clickRestoreLoginButton() {
        driver.findElement(restoreLoginButton).click();
    }

    @Step("Ввести эмейл")
    public void setEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Вход в аккаунт")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    @Step("Извлекаем текст из элемента 'Оформить заказ'")
    public String displayedCreateOrderButton() {
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Проверяем, что появилась форма входа")
    public void displayedLoginForm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginForm));
    }

    @Step("Появление хедера")
    public void displayedHeader() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }
}