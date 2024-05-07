package org.example;

import org.example.pages.LoginButtonsAtPage;
import org.example.pages.MainPage;
import org.example.browser.Browser;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;

import static org.example.constants.Url.URL_BURGERS;
import static org.junit.Assert.assertEquals;

public class SectionConstructorTest extends Browser {

    @Before
    public void openSite() {
        driver.get(URL_BURGERS);

        LoginButtonsAtPage loginButtonsAtPage = new LoginButtonsAtPage(driver);
        loginButtonsAtPage.displayedHeader();
    }

    @Test
    @DisplayName("Переход к разделу: 'Булки'")
    @Description("В разделе 'Конструктор' переход к разделу: 'Булки' без входа в аккаунт ")
    public void bunSectionTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesSectionButton();
        objMainPage.clickBunSectionButton();
        String textSection = objMainPage.getTextSection();
        assertEquals("Булки", textSection);
    }

    @Test
    @DisplayName("Переход к разделу: 'Соусы'")
    @Description("В разделе 'Конструктор' переход к разделу: 'Соусы'")
    public void saucesSectionTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesSectionButton();
        String textSection = objMainPage.getTextSection();
        assertEquals("Соусы", textSection);
    }

    @Test
    @DisplayName("Переход к разделу: 'Начинки'")
    @Description("В разделе 'Конструктор' переход к разделу: 'Начинки'")
    public void fillingSectionTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillinпSectionButton();
        String textSection = objMainPage.getTextSection();
        assertEquals("Начинки", textSection);
    }

    @After
    public void closeOut() {
        driver.quit();
    }
}
