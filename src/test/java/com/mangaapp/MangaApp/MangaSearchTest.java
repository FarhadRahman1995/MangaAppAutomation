package com.mangaapp.MangaApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MangaSearchTest extends LoginTest {
    public MangaPage mangaPage;

    @Test
    public void testSearchFunctionality() throws InterruptedException {
        // Search for "Naruto"
        mangaPage = new MangaPage(driver);
        
    	mangaPage.getSearchBox().click();Thread.sleep(2000);
        mangaPage.getSearchBox().sendKeys("Naruto");Thread.sleep(2000);
        mangaPage.getSearchButton().click();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"manga-name\"]")));Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Naruto"), "Naruto manga is not displayed");Thread.sleep(2000);

        // Search for "One Piece"
        mangaPage.getSearchBox().clear();Thread.sleep(2000);
        mangaPage.getSearchBox().sendKeys("One Piece");Thread.sleep(2000);
        mangaPage.getSearchButton().click();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"manga-name\"]")));Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("One Piece"), "One Piece manga is not displayed");Thread.sleep(2000);

        // Search for "Seven Deadly Sins"
        mangaPage.getSearchBox().clear();Thread.sleep(2000);
        mangaPage.getSearchBox().sendKeys("Dragon Ball Z");Thread.sleep(2000);
        mangaPage.getSearchButton().click();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"manga-name\"]")));Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Dragon Ball Z"), "Dragon Ball Z manga is not displayed");Thread.sleep(2000);

        // Search for a term that returns no results
        mangaPage.getSearchBox().clear();Thread.sleep(2000);
        mangaPage.getSearchBox().sendKeys("loooool");Thread.sleep(2000);
        mangaPage.getSearchButton().click();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(mangaPage.getNoResultsMessage()));Thread.sleep(2000);
        Assert.assertTrue(mangaPage.getNoResultsMessage().isDisplayed(), "No manga found message is not displayed");Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}