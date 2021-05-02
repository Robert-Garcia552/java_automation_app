package com.framework.uitests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static com.testframework.BrowserBase.getChromeDriver;

public class BaseTestClass {
    public static final String BASE_URL = "https://github.com/";
    public static final String USER = "Robert-Garcia552";
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = getChromeDriver();
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }
}
