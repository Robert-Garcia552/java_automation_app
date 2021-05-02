package com.framework.uitests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTabTests extends BaseTestClass {

    @BeforeEach
    void repoTabSetup() {
        driver.get(BASE_URL + USER);
    }

    @Test
    void repoCountIsCorrect() {

        // Act
        driver.findElement(By.partialLinkText("Repositories")).click();
        List<WebElement> repoListElements = driver.findElements(By.cssSelector("#user-repositories-list > ul > li"));
        WebElement count = driver.findElement(By.className("Counter"));

        // Assert
        assertEquals(count.getText(), String.valueOf(repoListElements.size()));
    }

}
