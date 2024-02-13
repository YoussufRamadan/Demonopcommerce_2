package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P00_homePage;
import pages.P04_searchResultPage;

import java.util.List;

import static steDefs.TestBase.driver;

public class D04_searchStepDef {
    P00_homePage homePage = new P00_homePage(driver);
    P04_searchResultPage resultPage = new P04_searchResultPage(driver);

    @When("user enters product name {string} in search box")
    public void user_enters_product_name_in_search_box(String name) {
        homePage.enter_search_word(name);
    }

    @And("user click on search button")
    public void user_click_on_search_button() {
        homePage.click_search();
    }

    @Then("search contains relevant results {string}")
    public void searchContainsRelevantResults(String name) {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homePage.getURL().contains("/search?q="));
        System.out.println("there are " + homePage.count_search_result() + " products of "+name);

        List<WebElement> results = homePage.find_search_results();
        for ( WebElement result : results){
            soft.assertTrue(resultPage.find_products_titles().contains(name));
        }
        soft.assertAll();
    }

    @When("user enters product sku {string} in search box")
    public void entersProductSkuInSearchBox(String sku) {
        homePage.enter_search_word(sku);
        System.out.println("there are " + homePage.count_search_result() + " products of "+sku);
    }


    @Then("product details contain relevant results {string}")
    public void productDetailsContainRelevantResults(String sku) {
        List<WebElement> titles = resultPage.find_products_titles();
        for (WebElement title : titles){
            resultPage.click_on_product_title();
            System.out.println("the actual sku is" + resultPage.get_product_sku());
            Assert.assertEquals(resultPage.get_product_sku(),sku);

        }
    }
}
