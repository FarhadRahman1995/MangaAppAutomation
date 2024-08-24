package com.mangaapp.MangaApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MangaPage {
    private WebDriver driver;

    public MangaPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.id("manga-search"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button"));
    }

    public WebElement getNoResultsMessage() {
        return driver.findElement(By.xpath("//p[text()='No manga found']"));
    }
}