package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {  // конструктор класса
        this.driver = driver;
    }

    private final By registrationLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private final By fieldRegistrationName = By.xpath("//fieldset[1]/div/div/input");
    private final By fieldRegistrationEmail = By.xpath("//fieldset[2]/div/div/input");
    private final By fieldRegistrationPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginWindow = By.className("Auth_login__3hAey");
    private final By passwordError = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");


    @Step("Нажать на ссылку 'Зарегистрироваться'")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Ввести данны в поле 'Имя'")
    public void setRegistrationName(String registrationName) {
        driver.findElement(fieldRegistrationName).sendKeys(registrationName);
    }

    @Step("Ввести данны в поле 'Эмейл'")
    public void setRegistrationEmail(String registrationEmail) {
        driver.findElement(fieldRegistrationEmail).sendKeys(registrationEmail);
    }

    @Step("Ввести данны в поле 'Пароль'")
    public void setRegistrationPassword(String registrationPassword) {
        driver.findElement(fieldRegistrationPassword).sendKeys(registrationPassword);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Регистрируемся")
    public void registration(String registrationName, String registrationEmail, String registrationPassword) {
        setRegistrationName(registrationName);
        setRegistrationEmail(registrationEmail);
        setRegistrationPassword(registrationPassword);
        clickRegistrationButton();
    }

    @Step("Проверяем появление окна входа")
    public void displayedLoginWindow() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginWindow));
    }

    @Step("Проверяем появление пуша об ошибке")
    public void displayedPasswordError() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordError));
    }
}
