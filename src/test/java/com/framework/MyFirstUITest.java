package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MyFirstUITest {
    public static final String BASE_URL = "https://github.com/";
    public static final String USER = "Robert-Garcia552";
    static ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
    static WebDriver driver = new ChromeDriver(options);

    @BeforeAll
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        // Arrange
        driver.get(BASE_URL + USER);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(USER, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        // Arrange
        driver.get(BASE_URL + USER);

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();

        String repo = "nextjs-tutorial";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + USER + "/" + repo, actualUrl);
    }

    @Test
    void repoCountIsCorrect() {

        // Arrange
        driver.get(BASE_URL + USER);

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();
        List<WebElement> repoListElements = driver.findElements(By.cssSelector("#user-repositories-list > ul > li"));
        WebElement count = driver.findElement(By.className("Counter"));

        // Assert
        assertEquals(count.getText(), String.valueOf(repoListElements.size()));
    }
}
