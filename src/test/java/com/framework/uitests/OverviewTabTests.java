package com.framework.uitests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabTests extends BaseTestClass {

    @BeforeEach
    void overviewTabSetup() {
        driver.get(BASE_URL + USER);
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(USER, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();

        String repo = "nextjs-tutorial";
        WebElement repoLink = driver.findElement(By.linkText(repo));

        repoLink.click();

        String actualUrl = driver.getCurrentUrl();

        // Assert
        assertEquals(BASE_URL + USER + "/" + repo, actualUrl);
    }
}
