package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class Test extends Utility {
    @Before
    public void setUp() { // Opening the browser window
        openBrowser("https://www.amazon.co.uk/");
    }

    @org.junit.Test
    public void dellProductsVerifyAndDisplay() {
        clickOnTheElement(By.id("sp-cc-accept")); // Clicking on the "Accept Cookies" button
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop"); // Typing "Dell Laptop" in the Search bar
        clickOnTheElement(By.id("nav-search-submit-button")); // Clicking on the Search button
        clickOnTheElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        String expectedNumberOfDellProducts = String.valueOf(30);
        List<WebElement> dellProducts = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a/span[contains(text(),'Dell')]"));
        String actual = String.valueOf(dellProducts.size());
        Assert.assertEquals("Total Number Of Products Mismatched", expectedNumberOfDellProducts, actual);
        for (WebElement a : dellProducts) {
            System.out.println(a.getText());
        }
        // Find and click Dell Latitude 5430
        clickOnTheElement(By.xpath("//span[normalize-space()='Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey']"));
        // Verify product text
        verifyTextDisplayed(By.xpath("//span[@id='productTitle']"), "Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey");

    }

    @After
    public void cutOff() {
        closeBrowser();
    }
}
