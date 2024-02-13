package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_loginPage extends PageBase{
    public P03_loginPage(WebDriver driver) {
        super(driver);
    }
    By emailField = By.className("email");
    By passwordField = By.id("Password");
    By loginButton = By.className("login-button");
    By pageTitle = By.className("page-title"); // should contain " Welcome, Please Sign In! " message
    By errorMessage = By.className("message-error");

    public void enter_email(String email){
        enterText(emailField, email);
    }
    public void enter_pw(String password){
        enterText(passwordField, password);
    }
    public void click_login (){
        clickElement(loginButton);
    }
    public String get_welcome_message(){
        return getElementText(pageTitle);
    }
    public String get_error_message(){
        return getElementText(errorMessage);
    }


}
