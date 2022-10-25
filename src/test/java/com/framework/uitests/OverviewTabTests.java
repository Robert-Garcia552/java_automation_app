package com.framework.uitests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
}
