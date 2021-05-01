package com.framework;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class MyFirstUITest {
    private String githubUrl = "https://github.com/";
    private String user = "Robert-Garcia552";

    @Test
    void userNameIsCorrectOnOverviewTab() {

        // Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(githubUrl + user);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        Assertions.assertEquals(user, actualUserName);

        driver.close();
    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        // Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(githubUrl + user);

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();

        String repo = "nextjs-tutorial";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualUrl = driver.getCurrentUrl();

        // Assert
        Assertions.assertEquals(githubUrl + user + "/" + repo, actualUrl);

        driver.close();
    }

    @Test
    void repoCountIsCorrect() {

        // Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(githubUrl + user);

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();
        List<WebElement> repoListElements = driver.findElements(By.cssSelector("#user-repositories-list > ul > li"));
        WebElement count = driver.findElement(By.className("Counter"));

        // Assert
        Assertions.assertEquals(count.getText(), String.valueOf(repoListElements.size()));

        driver.close();
    }
}
