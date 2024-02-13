package steDefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.P00_homePage;
import pages.P01_register;
import pages.P02_registerresult;

import static org.testng.Assert.assertEquals;
import static steDefs.TestBase.driver;

public class D01_registerStepDef {

    P00_homePage homePage = new P00_homePage(driver);
    P01_register Register_p = new P01_register(driver);
    P02_registerresult result = new P02_registerresult(driver);

    @Given("user is at home page")
    public void user_is_at_home_page() {
        Assert.assertEquals(homePage.getPageTitle(),"nopCommerce demo store");
    }

    @When("he clicks on register tap")
    public void he_clicks_on_register_tap() {
        homePage.click_register_tap();
        Assert.assertEquals(Register_p.get_register_title(),"Register");
    }

    @And("choose his {string}")
    public void choose_his(String Gender) {
        if (Gender.equals("Male")) // shoiuld use .equal or .contain
            Register_p.click_on_Male();
            else if (Gender.equals("Female"))
                Register_p.click_on_Female();

    }
    @And("enters his Fname {string}")
    public void FirstName (String FirstName) {
        Register_p.enter_first_name(FirstName);
    }
    @And("enters his Secondname {string}")
    public void LastName (String SecondName) {
        Register_p.enter_last_name(SecondName); //
    }
    @And("select his Day {string}")
    public void selectDay(String Day) {
        Register_p.select_day(Day);
    }
    @And("select his Month {string}")
    public void selectMonth(String Month) {
        Register_p.select_month(Month);
    }
    @And("select his Year {string}")
    public void selectYear(String Year) {
        Register_p.select_year(Year);
    }
    @And("enters his Company {string}")
    public void CompanyName (String CompanyName) {
        Register_p.enter_company_name(CompanyName); // CompanyName
    }

    @And("check on newsletter button")
    public void check_on_newsletter_button() {
       Register_p.check_on_newsletter();
    }

    @And("enters his valid {string}")
    public void email (String email) {
        Register_p.enter_email(email);
    }
    @And("enters and confirms his {string}")
    public void enterPassword (String Password) {
        Register_p.enter_and_confirm_PW(Password);
    }

    @And("clicks on register button")
    public void clicks_on_register_button() {
        Register_p.click_register_btn();
    }

    @Then("a successful message {string} should be displayed")
    public void a_successful_message_should_be_displayed(String message) {
        Assert.assertEquals(result.get_success_message(),message);

    }

    @Then("a continue button should be displayed")
    public void a_continue_button_should_be_displayed() {
        Assert.assertTrue(result.cont_button_is_displayed());
    }

}
