package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P00_homePage;
import pages.P03_loginPage;

import static steDefs.TestBase.driver;

public class D02_loginStepDef {

    P00_homePage homePage = new P00_homePage(driver);
    P03_loginPage loginPage = new P03_loginPage(driver);

    @When("user click on login tab")
    public void user_Click_On_LoginTab() {
        homePage.click_login_tab();
        Assert.assertEquals(loginPage.get_welcome_message(),"Welcome, Please Sign In!");
    }

    @And("user enters his valid email {string}")
    public void userEntersHisValidEmail(String email) {
        loginPage.enter_email(email);
    }

    @And("user enters his valid PW {string}")
    public void userEntersHisValidPW(String password) {
        loginPage.enter_pw(password);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        loginPage.click_login();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(homePage.logout_is_displayed());
    }


}
