package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.P00_homePage;

import java.util.List;

import static steDefs.TestBase.driver;

public class D03_CurrenciesStepDef {
    P00_homePage homePage = new P00_homePage(driver);

    @When("user choose currency to {string}")
    public void userChooseCurrencyTo(String currency) {
        homePage.select_currency("Euro");
    }
    @And("user slide down in page")
    public void userSlideDownInPage() {
        homePage.scroll_to_products();
    }
    @Then("all four products prices must contain € sign")
    public void verify_currency_symbol() {
        String symbol = "€";

        List<WebElement> prices = homePage.find_prices_list();
        for (WebElement price : prices) {
            Assert.assertTrue(homePage.get_prices_text().contains("€"),"not all contain € sign");

        }
    }

}
