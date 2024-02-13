package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_register extends PageBase{
    By page_Title_Text = By.className("page-title"); // to assert it contains (Register) text
    By maleOption = By.id("gender-male");
    By femaleOption = By.cssSelector("[value=\"F\"]");
    By fnameField = By.id("FirstName");
    By lnameField = By.id("LastName");
    // Date of birth elements
    By dayList = By.name("DateOfBirthDay");
    By monthList = By.name("DateOfBirthMonth");
    By yearList = By.name("DateOfBirthYear");
    ///
    By emailField =By.cssSelector("input[type=\"email\"]");
    By companyField = By.name("Company");
    By newsletter_check = By.cssSelector("input[name=\"Newsletter\"][value=\"true\"]");
    By passwordField = By.id("Password");
    By confirmPW_Field = By.id("ConfirmPassword");
    By register_button = By.name("register-button");

    public P01_register(WebDriver driver) {
        super(driver);
    }
    public void click_on_Male (){
        clickElement(maleOption);
    }
    public void click_on_Female (){
        clickElement(femaleOption);
    }
    public void enter_first_name (String firstName){
        enterText(fnameField,firstName);
    }
    public void enter_last_name (String lastName){
        enterText(lnameField,lastName);
    }
    public void select_day (String day){
        selectElement_byValue(dayList, day);
    }
    public void select_month (String month){
        selectElement_byValue(monthList, month);
    }
        public void select_year (String year){
        selectElement_byValue(yearList, year);
    }
    public void enter_email (String email){
        enterText(emailField,email);
    }
    public void enter_company_name (String company){
        enterText(companyField, company);
    }
    public void check_on_newsletter (){
        clickElement(newsletter_check);
    }
    public void enter_and_confirm_PW (String password){
        enterText(passwordField, password);
        enterText(confirmPW_Field, password);
    }
    public void click_register_btn(){
        clickElement(register_button);
    }
    public String get_register_title(){
        return getElementText(page_Title_Text);
    }




}
