package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _02_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the login form")
    public void validateTheLoginForm(){

    }

    @Test(priority = 2, description = "Test Case 02 - Validate the valid login")
    public void validateTheValidLogin(){

    }

    @Test(priority = 3, description = "Test Case 03 - Validate the logout")
    public void validateTheLogOut(){

    }

    @Test(priority = 4, description = "Test Case 04 - Validate the Forgot Password? Link and Reset Password modal")
    public void validateTheForgotPasswordLinkAndResetPasswordModal(){

    }

    @Test(priority = 5, description = "Test Case 05 - Validate the Reset Password modal close button")
    public void validateTheResetPasswordModalCloseButton(){
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();

        WebElement modal = driver.findElement(By.cssSelector(".modal-card"));
        Assert.assertTrue(modal.isDisplayed());

        WebElement modalCloseButton = driver.findElement(By.cssSelector(".delete"));
        modalCloseButton.click();

        //One way to validate the modal is not displayed
        try{
            Assert.assertFalse(modal.isDisplayed());
        } catch (StaleElementReferenceException e){
            Assert.assertTrue(true);
        }
    }
}
