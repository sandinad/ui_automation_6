package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base{
    /*
    COMPLETE PROJECT01 HERE
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test(priority = 3, description = "Test Case 03 - Validate the Gender radio button")
    public void validateTheGenderRadioButton(){
        WebElement genderLabel = driver.findElement(By.xpath("//label[text()='Gender *']"));
        List<WebElement> genderRadioButtonLabels = driver.findElements(By.cssSelector(".radio"));
        List<WebElement> genderRadioButtonInputs = driver.findElements(By.cssSelector(".radio>input"));

        String[] expectedGenderLabelText = {"Male", "Female", "Prefer not to disclose"};

        Assert.assertEquals(genderLabel.getText(), "Gender *");

        Assert.assertEquals(genderRadioButtonInputs.get(0).getAttribute("required"), "true");

        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(genderRadioButtonLabels.get(i).getText(), expectedGenderLabelText[i]);
            Assert.assertTrue(genderRadioButtonInputs.get(i).isEnabled());
            Assert.assertFalse(genderRadioButtonInputs.get(i).isSelected());
        }

        genderRadioButtonInputs.get(0).click();
        Waiter.pause(2);
        Assert.assertTrue(genderRadioButtonInputs.get(0).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(1).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(2).isSelected());

        genderRadioButtonInputs.get(1).click();
        Waiter.pause(2);
        Assert.assertFalse(genderRadioButtonInputs.get(0).isSelected());
        Assert.assertTrue(genderRadioButtonInputs.get(1).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(2).isSelected());

        Waiter.pause(5);
    }


    @Test(priority = 8, description = "Test Case 08 - Validate the Consent checkbox")
    public void validateTheConsentCheckbox(){
        WebElement consentCheckBoxLabel = driver.findElement(By.cssSelector(".checkbox"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        Assert.assertTrue(consentCheckBoxLabel.isDisplayed());
        Assert.assertEquals(consentCheckBoxLabel.getText(), "I give my consent to be contacted.");

        Assert.assertEquals(consentCheckBox.getAttribute("required"), "true");
        Assert.assertTrue(consentCheckBox.isEnabled());
        Assert.assertFalse(consentCheckBox.isSelected());

        consentCheckBox.click();
        Waiter.pause(2);
        Assert.assertTrue(consentCheckBox.isSelected());

        consentCheckBox.click();
        Waiter.pause(2);
        Assert.assertFalse(consentCheckBox.isSelected());
    }

    @Test(priority = 10, description = "Test Case 10 - Validate the form submission")
    public void validateTheFormSubmission(){
        Faker faker = new Faker();

        WebElement nameInputBox = driver.findElement(By.xpath("//label[@for='name']/..//input"));
        List<WebElement> genders = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInputBox = driver.findElement(By.xpath("//label[text()='Address']/..//input"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type='phone']"));
        WebElement messageTextArea = driver.findElement(By.tagName("textarea"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        nameInputBox.sendKeys(faker.name().fullName());
        genders.get(0).click();
        addressInputBox.sendKeys(faker.address().fullAddress());
        emailInputBox.sendKeys("abcd@gmail.com");
        phoneInputBox.sendKeys(faker.phoneNumber().cellPhone());
        messageTextArea.sendKeys(faker.gameOfThrones().quote());
        consentCheckBox.click();
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.cssSelector(".mt-5"));

        Assert.assertTrue(confirmationMessage.isDisplayed());
        Assert.assertEquals(confirmationMessage.getText(), "Thanks for submitting!");

        Waiter.pause(30);
    }
}
