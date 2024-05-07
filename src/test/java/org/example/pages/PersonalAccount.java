package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class PersonalAccount {

    private final WebDriver driver;

    public PersonalAccount(WebDriver driver) {  // конструктор класса
        this.driver = driver;
    }

    private final By exitButton = By.xpath("//*[text()='Выход']");
    private final By profileSection = By.xpath(".//a[text()='Профиль']");


    @Step("Нажимаем на кнопку 'Выход'")
    public void clickExitButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton)).click();

    }

    @Step("Извлекаем текст из элемента 'Профиль'")
    public String displayedProfileSection() {
        return driver.findElement(profileSection).getText();
    }
}
