package com.mangaapp.MangaApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[text()='Login']"));
    }

    public WebElement LogingetTitle() {
        return driver.findElement(By.xpath("//h2[text()='Login']"));
    }
    public WebElement MangagetTitle() {
        return driver.findElement(By.xpath("//h1[text()='Manga You Should Read']"));
    }
}
