package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P00_homePage;

import java.util.concurrent.TimeUnit;

import static steDefs.TestBase.driver;

public class D08_WishlistStepDef {
    P00_homePage homePage = new P00_homePage(driver);
    SoftAssert soft = new SoftAssert();

    @When("user click on wishlist button for a product")
    public void user_click_on_wishlist_button_for_a_product() {
        //driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        homePage.add_htc_to_wishlist();

    }

    @Then("success message {string} should must appear")
    public void success_message_should_must_appear(String string) {
       // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        soft.assertTrue(homePage.wishlist_success_msg_isdisplayed()); // this includes explicit wait
    }


    @And("the background of message is green \\(#4bb07a)")
    public void the_background_of_message_is_green_4bb07a() {
        // to get hex color
        String hexColor = Color.fromString(homePage.get_success_message_color()).asHex();
        System.out.println("background color is " + hexColor);
        soft.assertEquals(hexColor,"#4bb07a");
    }

    // scenario 2


    @And("user opens wishlist tab")
    public void user_opens_wishlist_tab() {
       homePage.wishlist_success_msg_isdisplayed();
       homePage.open_wishlist();
    }

    @Then("then wishlist quanitiy value should be greater than zero")
    public void then_wishlist_quanitiy_value_should_be_greater_than_zero() {
        int wishlistQty = homePage.get_wishlist_qty();
        System.out.println("wishlist Qty is "+ wishlistQty);
        soft.assertTrue(wishlistQty>0);
        soft.assertAll();
    }



}
