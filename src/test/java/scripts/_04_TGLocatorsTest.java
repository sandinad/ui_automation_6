package scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _04_TGLocatorsTest extends Base{
    /*
    Go to "https://techglobal-training.com/frontend/xpath-css-locators"
    Validate the header is "Xpath-CSS Locators"
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/xpath-css-locators");
    }

    @Test
    public void validateTheHeader(){

    }
}
