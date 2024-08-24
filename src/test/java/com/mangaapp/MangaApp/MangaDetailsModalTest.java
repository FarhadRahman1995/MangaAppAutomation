package com.mangaapp.MangaApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class MangaDetailsModalTest extends LoginTest {
    public MangaPage mangaPage;

    @Test
    public void testMangaDetailsModal() throws InterruptedException {
        // Search for "Attack on Titan"
    	mangaPage = new MangaPage(driver);
    	mangaPage.getSearchBox().click();Thread.sleep(2000);
        mangaPage.getSearchBox().sendKeys("Attack on Titan");Thread.sleep(2000);
        mangaPage.getSearchButton().click();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"manga-name\"]")));Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Attack on Titan"), "Attack on Titan manga is not displayed");Thread.sleep(2000);
        
        // Click the "Details" link of the "One Piece" card
        WebElement detailsLink = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/p[1]/span"));Thread.sleep(2000);
        detailsLink.click();Thread.sleep(2000);

        // Verify that the modal appears and displays the correct manga information
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div")));Thread.sleep(2000);
        Assert.assertTrue(modal.isDisplayed(), "Manga details modal is not displayed");Thread.sleep(2000);

        WebElement modalTitle = modal.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/h3"));Thread.sleep(2000);
        Assert.assertTrue(modalTitle.getText().contains("Attack on Titan"), "Modal title does not contain 'Attack on Titan'");

        WebElement modalImage = modal.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/img"));
        Assert.assertTrue(modalImage.isDisplayed(), "Manga image is not displayed");

        WebElement modalSummary = modal.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/p"));
        Assert.assertTrue(modalSummary.isDisplayed(), "Manga summary is not displayed");

        // Click the "Close" button on the modal
        WebElement closeButton = modal.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/button"));
        closeButton.click();Thread.sleep(2000);

        // Verify that the modal is closed and no longer visible
        wait.until(ExpectedConditions.invisibilityOf(modal));Thread.sleep(2000);
        System.out.println("Manga details modal is successfully closed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}