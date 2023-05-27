package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _11_TGDropdownsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest(){

        Select select = new Select(driver.findElement(By.id("product_dropdown")));

        select.selectByVisibleText("iPhone 14 Pro Max");
    }

    @Test
    public void productColorTest(){
        Select select = new Select(driver.findElement(By.id("color_dropdown")));

        select.selectByIndex(2);
    }
}
