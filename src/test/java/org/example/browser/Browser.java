package org.example.browser;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class Browser {
    protected WebDriver driver;

    @Before
    public void getWebDriver() {
        String browser = System.getProperty("browser");
        if (StringUtils.isEmpty(browser)) {
            browser = "default";
        }

        switch (browser) {
            case "chrome": {
                setUpChrome();
                break;
            }
            case "yandex": {
                setUpYandex();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void setUpChrome() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    private void setUpYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        options.setBinary("C:\\Users\\User\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
}

