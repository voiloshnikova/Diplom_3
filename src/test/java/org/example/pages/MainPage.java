package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private final By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private final By textConstructorSection = By.xpath(".//h1[text()='Соберите бургер']");
    private final By bunSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private final By saucesSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private final By fillingSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    private final By currentSection = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By logo = By.xpath("//div/a[@href='/']");

    @Step("Нажимаем на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажимаем на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Извлекаем текст из элемента 'Соберите бургер'")
    public String displayedTextConstructorSection() {
        return driver.findElement(textConstructorSection).getText();
    }

    @Step("Извлекаем текст из элемента 'Булки'")
    public void clickBunSectionButton() {
        driver.findElement(bunSectionButton).click();
    }

    @Step("Извлекаем текст из элемента 'Соусы'")
    public void clickSaucesSectionButton() {
        driver.findElement(saucesSectionButton).click();
    }

    @Step("Извлекаем текст из элемента 'Начинки'")
    public void clickFillinпSectionButton() {
        driver.findElement(fillingSectionButton).click();
    }

    @Step("Извлекаем текст из активного раздела в конструкторе")
    public String getTextSection() {
        return driver.findElement(currentSection).getText();
    }

    @Step("Нажимаем на 'Лого'")
    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
