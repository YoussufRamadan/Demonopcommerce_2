package steDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P00_homePage;

import static steDefs.TestBase.driver;

public class D06_homeSlidersStepDef {
    P00_homePage homePage = new P00_homePage(driver);
    String container;
    SoftAssert soft =new SoftAssert();

    @When("click on home {string}")
    public void clickOnHome(String slider) {
        System.out.println(slider);
       container =slider;
       if (slider.contains("galaxy"))
           homePage.click_on_galaxy();
       else homePage.click_on_iphone();
    }

    @Then("the iphone or galaxy page opens")
    public void the_iphone_or_galaxy_page_opens() {
        if (container.contains("galaxy"))
            soft.assertEquals(homePage.getURL(),"https://demo.nopcommerce.com/galaxy-s-22");
        else if (container.contains("iphone"))
            soft.assertEquals(homePage.getURL(),"https://demo.nopcommerce.com/iphone-14");
        soft.assertAll();
    }
}

