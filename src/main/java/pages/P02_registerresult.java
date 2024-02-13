package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_registerresult extends PageBase {

    By successPage = By.className("result");
    By cont_button = By.className("button-1");
    public P02_registerresult(WebDriver driver) {
        super(driver);
    }

    public String get_success_message(){
        return  getElementText(successPage);
    }

    public boolean cont_button_is_displayed(){
        return is_displayed(cont_button);
    }

}
