package org.example;

import org.example.pages.LoginButtonsAtPage;
import org.example.pages.MainPage;
import org.example.pages.PersonalAccount;
import org.example.browser.Browser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.util.BaseHttpClient;
import org.example.util.UserMethods;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import org.example.pojo.User;

import static org.example.constants.Url.URL_BURGERS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class FromPersonalAccountToConstructorTest extends Browser {

    private final String email = "some_test_mail@gmail.com";
    private final String password = "123456";
    private final String name = "some_name";

    private String accessToken;

    @Before
    public void openSite() {
        RestAssured.requestSpecification = BaseHttpClient.baseRequestSpec();

        User user = new User(email, password, name);
        UserMethods userMethods = new UserMethods();
        userMethods.createUser(user)
                .then().assertThat().body("success", equalTo(true))
                .and()
                .statusCode(200);

        Response responseAccessToken = userMethods.loginUser(user);
        responseAccessToken.then().assertThat().body("accessToken", notNullValue())
                .and()
                .statusCode(200);

        this.accessToken = responseAccessToken.body().jsonPath().getString("accessToken");

        driver.get(URL_BURGERS);

        LoginButtonsAtPage loginButtonsAtPage = new LoginButtonsAtPage(driver);
        loginButtonsAtPage.displayedHeader();

        LoginButtonsAtPage objLoginButtonsAtPage = new LoginButtonsAtPage(driver);
        objLoginButtonsAtPage.clickLoginInAccountButton();
        objLoginButtonsAtPage.login(email, password);
        objLoginButtonsAtPage.clickLoginButton();
    }

    @Test
    @DisplayName("Переход по кнопке 'Конструктор'")
    public void transitionToConctructorTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        objMainPage.clickConstructorButton();
        String textSection = objMainPage.displayedTextConstructorSection();
        assertEquals("Соберите бургер", textSection);
    }

    @Test
    @DisplayName("Переход по лого")
    public void transitionToLogoTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        objMainPage.clickLogo();
        String textSection = objMainPage.displayedTextConstructorSection();
        assertEquals("Соберите бургер", textSection);
    }

    @Test
    @DisplayName("Переход по кнопке 'Личный кабинет'")
    public void transitionToPersonalAccountTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConstructorButton();
        objMainPage.clickPersonalAccountButton();
        PersonalAccount objPersonalAccount = new PersonalAccount(driver);
        String textSection = objPersonalAccount.displayedProfileSection();
        assertEquals("Профиль", textSection);
    }

    @After
    public void closeOut() {
        driver.quit();

        UserMethods userMethods = new UserMethods();
        userMethods.deleteUser(accessToken);
    }
}
