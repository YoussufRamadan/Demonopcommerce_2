package steDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P00_homePage;

import static steDefs.TestBase.driver;

public class D07_followUsStepDef {
    P00_homePage homePage = new P00_homePage(driver);
    SoftAssert soft = new SoftAssert();

    @When("user opens facebook link")
    public void user_opens_facebook_link() {
        homePage.open_facebook();
    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        homePage.open_twitter();
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        homePage.open_youtube();
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        homePage.open_rss();
    }

    @Then("{string} is opened in new tab")
    public void is_opened_in_new_tab(String string) {
        homePage.wait_until_number_of_tabs(2);
        homePage.switch_tabs(1);

        System.out.println("URL is " + homePage.getURL());
        soft.assertTrue(homePage.getURL().contains(string));
    }



}
