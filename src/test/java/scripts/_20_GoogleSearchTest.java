package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;

public class _20_GoogleSearchTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage();
        googleSearchResultsPage = new GoogleSearchResultsPage();
    }

    @Test(priority = 1, description = "Validate the Google Search")
    public void validateTheGoogleSearchResult(){
        googleSearchPage.search("canvas painting");

        Assert.assertTrue(googleSearchResultsPage.resultTag.isDisplayed());
        System.out.println(googleSearchResultsPage.resultTag.getText()); // About 1,010,000,000 results (0.60 seconds)
    }


}
