package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project2Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _04_ProjectTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-4");
        project2Page = new Project2Page();
    }
   @Test
    public class InventoryTableValidation {
        public  void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");


            WebDriver driver = new ChromeDriver();


            driver.get("https://techglobal-training.com/frontend/project-4");


            WebElement inventoryHeading = driver.findElement(By.xpath("//h2[contains(text(), 'Inventory')]"));
            assert inventoryHeading.isDisplayed() : "Inventory heading is not displayed.";


            WebElement quantityHeader = driver.findElement(By.xpath("//th[contains(text(), 'Quantity')]"));
            WebElement productHeader = driver.findElement(By.xpath("//th[contains(text(), 'Product')]"));
            WebElement priceHeader = driver.findElement(By.xpath("//th[contains(text(), 'Price $')]"));
            WebElement totalHeader = driver.findElement(By.xpath("//th[contains(text(), 'Total $')]"));

            assert quantityHeader.isDisplayed() : "Quantity header is not displayed.";
            assert productHeader.isDisplayed() : "Product header is not displayed.";
            assert priceHeader.isDisplayed() : "Price header is not displayed.";
            assert totalHeader.isDisplayed() : "Total header is not displayed.";


            WebElement table = driver.findElement(By.xpath("//table[@id='inventory-table']"));
            WebElement tableBody = table.findElement(By.tagName("tbody"));
            String expectedTableContent = "1 iPhone 1,000 1,000\n3 Airpods 100 300\n2 iPad 500 1,000";

            assert tableBody.getText().equals(expectedTableContent) : "Table rows do not match the expected content.";


            WebElement addButton = driver.findElement(By.xpath("//button[text()='ADD PRODUCT']"));
            assert addButton.isEnabled() : "ADD PRODUCT button is not enabled.";


            WebElement totalText = driver.findElement(By.xpath("//div[contains(text(), 'Total = $2,300')]"));
            assert totalText.isDisplayed() : "Total text is not displayed.";


            driver.quit();
        }




    }
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://techglobal-training.com/frontend/project-4");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='ADD PRODUCT']"));
        addButton.click();

        WebElement modalHeading = driver.findElement(By.xpath("//h4[contains(text(), 'Add New Product')]"));
        assert modalHeading.isDisplayed() : "Add New Product modal heading is not displayed.";

        WebElement closeButton = driver.findElement(By.xpath("//button[@class='close']"));
        assert closeButton.isEnabled() : "X button is not enabled.";

        WebElement quantityLabel = driver.findElement(By.xpath("//label[contains(text(), 'Please select the quantity')]"));
        assert quantityLabel.isDisplayed() : "Please select the quantity label is not displayed.";

        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='quantity']"));
        assert quantityInput.isEnabled() : "Quantity input box is not enabled.";

        WebElement productLabel = driver.findElement(By.xpath("//label[contains(text(), 'Please enter the name of the product')]"));
        assert productLabel.isDisplayed() : "Please enter the name of the product label is not displayed.";

        WebElement productInput = driver.findElement(By.xpath("//input[@id='product']"));
        assert productInput.isEnabled() : "Product input box is not enabled.";

        WebElement priceLabel = driver.findElement(By.xpath("//label[contains(text(), 'Please enter the price of the product')]"));
        assert priceLabel.isDisplayed() : "Please enter the price of the product label is not displayed.";

        WebElement priceInput = driver.findElement(By.xpath("//input[@id='price']"));
        assert priceInput.isEnabled() : "Price input box is not enabled.";

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='SUBMIT']"));
        assert submitButton.isEnabled() : "SUBMIT button is not enabled.";

        driver.quit();
    }


}
