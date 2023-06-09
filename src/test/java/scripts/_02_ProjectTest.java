package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the login form")
    public void validateTheLoginForm(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameInputBoxLabel = driver.findElement(By.cssSelector("label[for='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordInputBoxLabel = driver.findElement(By.cssSelector("label[for='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertNotEquals(usernameInputBox.getAttribute("required"), "true");
        Assert.assertTrue(usernameInputBoxLabel.isDisplayed());
        Assert.assertEquals(usernameInputBoxLabel.getText(), "Please enter your username");

        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertNotEquals(passwordInputBox.getAttribute("required"), "true");
        Assert.assertTrue(passwordInputBoxLabel.isDisplayed());
        Assert.assertEquals(passwordInputBoxLabel.getText(), "Please enter your password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "Test Case 02 - Validate the valid login")
    public void validateTheValidLogin(){
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();

        WebElement loginMessage = driver.findElement(By.id("success_lgn"));
        WebElement logoutButton = driver.findElement(By.id("logout"));

        Assert.assertTrue(loginMessage.isDisplayed());
        Assert.assertEquals(loginMessage.getText(), "You are logged in");

        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertTrue(logoutButton.isEnabled());
        Assert.assertEquals(logoutButton.getText(), "LOGOUT");
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
