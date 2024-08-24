package com.mangaapp.MangaApp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "H:\\ECLIPSE WORKSPACE\\MyAlice\\MangaAppAutomation\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://myalice-automation-test.netlify.app");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginFunctionality() throws InterruptedException {
        // Verify that the login page is displayed
        wait.until(ExpectedConditions.visibilityOf(loginPage.LogingetTitle()));
        Assert.assertTrue(loginPage.LogingetTitle().isDisplayed(), "Login page title is not displayed");
        Thread.sleep(2000);
        // Enter valid login credentials
        loginPage.getUsernameField().sendKeys("testuser");
        Thread.sleep(2000);
        loginPage.getPasswordField().sendKeys("password");
        Thread.sleep(2000);

        // Click the "Login" button
        loginPage.getLoginButton().click();
        Thread.sleep(2000);

        // Verify that the user is redirected to the manga search page
        wait.until(ExpectedConditions.visibilityOf(loginPage.MangagetTitle()));
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.MangagetTitle().isDisplayed(), "Manga search page title is not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}