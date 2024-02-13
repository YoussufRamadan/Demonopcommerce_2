package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_searchResultPage extends PageBase{
    public P04_searchResultPage(WebDriver driver) {
        super(driver);
    }
    By productTitle  = By.className("picture");
    By productSKU = By.cssSelector("div[class=\"sku\"] span[class=\"value\"]");

    public List<WebElement> find_products_titles (){
        return find_list_of_elements(productTitle);
    }

    public void click_on_product_title(){
        clickElement(productTitle);
    }
    public String get_product_sku (){
        return getElementText(productSKU);
    }



}
