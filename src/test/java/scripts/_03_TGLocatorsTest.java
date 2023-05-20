package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _03_TGLocatorsTest {
    /*
    Test case 1:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Kiwi" paragraph
     */

    public static WebDriver driver; // declaration

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(); // initialization

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://techglobal-training.com/frontend/locators");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void validateKiwiParagraph(){
        WebElement kiwi_paragraph = driver.findElement(By.id("item_kiwi"));

        Assert.assertTrue(kiwi_paragraph.isDisplayed());
        Assert.assertEquals(kiwi_paragraph.getText(), "Kiwi");
    }


     /*
    Test case 2:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Orange" paragraph
     */
}
