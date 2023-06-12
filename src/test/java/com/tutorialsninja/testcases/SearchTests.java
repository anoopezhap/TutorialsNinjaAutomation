package com.tutorialsninja.testcases;

import com.tutorialsninja.base.TestBase;
import com.tutorialsninja.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    @Test(priority = 1)
    public void searchWithValidProduct()
    {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.validProduct("macbook"));
    }

    @Test(priority = 2)
    public void searchWithInvalidProduct()
    {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.invalidProduct("anoop"));
    }


}
