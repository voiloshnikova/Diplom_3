package org.example;

import org.example.pages.LoginButtonsAtPage;
import org.example.browser.Browser;
import io.restassured.response.Response;
import org.example.util.UserMethods;
import org.junit.After;
import org.example.pages.RegistrationPage;
import org.junit.Test;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.example.pojo.User;

import static org.example.constants.Url.URL_BURGERS;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTest extends Browser {

    private final String email = "some_test_mail@gmail.com";
    private final String password = "123456";
    private final String name = "some_name";
    private final String passwordIncorrect = "123";
    private String accessToken;

    @Before
    public void openSite() {
        driver.get(URL_BURGERS);

        LoginButtonsAtPage loginButtonsAtPage = new LoginButtonsAtPage(driver);
        loginButtonsAtPage.displayedHeader();
    }

    @Test
    @DisplayName("Регистрация с корректным паролем")
    @Description("Пароль должен быть =>6 символов")
    public void registrationTestPositiv() {
        LoginButtonsAtPage objLoginButtonsAtPage = new LoginButtonsAtPage(driver);
        objLoginButtonsAtPage.clickPersonalAccountButton();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickRegistrationLink();
        objRegistrationPage.registration(name, email, password);
        objRegistrationPage.displayedLoginWindow();

        User user = new User(email, password, name);
        UserMethods userMethods = new UserMethods();
        Response responseAccessToken = userMethods.loginUser(user);
        responseAccessToken.then().assertThat().body("accessToken", notNullValue())
                .and()
                .statusCode(200);
        this.accessToken = responseAccessToken.body().jsonPath().getString("accessToken");
        userMethods.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Регистрация с не корректным паролем")
    @Description("Пароль менее 6 символов")
    public void registrationTestNegativ() {
        LoginButtonsAtPage objLoginButtonsAtPage = new LoginButtonsAtPage(driver);
        objLoginButtonsAtPage.clickPersonalAccountButton();

        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickRegistrationLink();
        objRegistrationPage.registration(name, email, passwordIncorrect);
        objRegistrationPage.displayedPasswordError();
    }

    @After
    public void closeOut() {
        driver.quit();
    }
}

