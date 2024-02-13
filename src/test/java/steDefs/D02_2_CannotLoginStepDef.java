package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.P00_homePage;
import pages.P03_loginPage;

import static steDefs.TestBase.driver;

public class D02_2_CannotLoginStepDef {

    P00_homePage homePage = new P00_homePage(driver);
    P03_loginPage loginPage = new P03_loginPage(driver);

    @And("user enter invalid email {string}")
    public void user_Enter_Invalid_Email(String email) {
        loginPage.enter_email(email);

    }

    @And("user enter invalid password {string}")
    public void user_Enter_Invalid_Password(String password) {
        loginPage.enter_pw(password);

    }
    @Then("user Cannot login to the system")
    public void user_cannot_Login_To_The_System() {
        loginPage.click_login();
        Assert.assertTrue(loginPage.get_error_message().contains("Login was unsuccessful"));
    }


}
