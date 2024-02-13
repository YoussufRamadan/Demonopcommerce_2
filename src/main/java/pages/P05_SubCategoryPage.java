package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_SubCategoryPage extends PageBase {
    public P05_SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    By visible_title = By.className("div[class=\"page-title\"] h1");
    public String get_visible_title (){
        return getElementText(visible_title);
    }

}
