package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {
    /*
    Go to https://www.google.com/
    Validate that the user see a search input box
     */

    @Test
    public void validateSearchBar() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver

        WebDriver driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait

        driver.get("https://www.google.com/");

        WebElement searchInputBox = driver.findElement(By.name("q"));

        Assert.assertTrue(searchInputBox.isDisplayed());

        Thread.sleep(5000);

        driver.quit();
    }
}
