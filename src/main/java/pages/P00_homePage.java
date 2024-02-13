package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P00_homePage extends PageBase {
    By registerTab = By.className("ico-register");
    By loginTab = By.className("ico-login");
    By logoutTab = By.className("ico-logout");
    By CurrencyList = By.id("customerCurrency");
    By productGrid = By.className("product-grid");
    By productsPrices = By.cssSelector("span[class=\"price actual-price\"]"); // to be used in the list of products
    By searchBox = By.className("search-box-text");
    By searchButton = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    By search_results = By.className("item-box");
    By category_list = By.xpath("(//div[@class=\"header-menu\"]/ul)[1]/li");// take care
    By sublist = By.className("sublist");
   By sub_categories = By.xpath( "(//div[@class=\"header-menu\"]/ul)[1]/li[2]/ul/li/a");// electronics only

   // this is how slider is located
    By iphoneSlider = By.cssSelector("div[id=\"nivo-slider\"] a");
    By galaxySlider = By.cssSelector("div[id=\"nivo-slider\"] a[2]");

    By facebook = By.className("facebook");
    By twitter = By.className("twitter");
    By youtube = By.className("youtube");
    By rss = By.className("rss");
    
    By wishlist_tab = By.className("wishlist-label");
    By htc_wishlist_button =
            By.cssSelector("div[data-productid =\"18\"] button[class=\"button-2 add-to-wishlist-button\"]");

    By wishlist_success_message = By.className("bar-notification-container");
    By wishlist_qty = By.className("qty-input");

    public P00_homePage(WebDriver driver) {
        super(driver);
    }

    public void click_register_tap (){
       clickElement(registerTab);
    }
    public void click_login_tab(){
        clickElement(loginTab);
    }
    public boolean logout_is_displayed (){
        return is_displayed(logoutTab);
    }
    public void select_currency (String currency){
        selectElement_byVisible(CurrencyList, currency);
    }
    public void scroll_to_products(){
        scroll_to_element(productGrid);
    }
   public List<WebElement> find_prices_list(){
       return find_list_of_elements(productsPrices);
    }
   public String get_prices_text(){
       return getElementText(productsPrices);
    }
   public void enter_search_word(String searcher ){
        enterText(searchBox,searcher);
    }
    public void click_search (){
        clickElement(searchButton);
    }
    public int count_search_result(){
        // to count number of results
        return find_list_of_elements(search_results).size();
    }
    public List<WebElement> find_search_results(){
       return find_list_of_elements(search_results);
    }

    // hoover on categories

    public void hoover_categories(){
        List<WebElement> categories = find_list_of_elements(category_list);
        hover_on_list(categories);
    }

    public String select_random_subcat(){
        // method to select random sub cat from electronics category and return the selected text
        int random = (int) Math.floor(Math.random()*((find_list_of_elements(sub_categories).size() - 1) +1)+0);// dont understand this
        Actions action = new Actions(driver);
        System.out.println(random);
        // ask about why should find list of elements
        String selection = find_list_of_elements(sub_categories).get(random).getText();
        action.moveToElement(find_list_of_elements(category_list).get(1)).perform();
        find_list_of_elements(sub_categories).get(random).click();
        return selection;
    }
    /*public List<WebElement> find_category_list(){
        return  find_list_of_elements(category_list);
    }*/
    public List<WebElement> find_sublist (){
        return find_list_of_elements(sub_categories);
    }

    /*public boolean sublist_is_displayed (){
        return is_displayed(sublist);
    }
   public void select_subcategory(String sub_category){
       selectElement_byVisible(sublist,sub_category);
    }*/

    // Home slider
    public void click_on_galaxy(){
        clickElement(galaxySlider);
    }
    public void click_on_iphone(){
        clickElement(iphoneSlider);
    }

    // follow us feature
    public void open_facebook (){
        clickElement(facebook);
    }
    public void open_twitter(){
        clickElement(twitter);
    }
    public void open_youtube(){
        clickElement(youtube);
}
    public void open_rss(){
        clickElement(rss);
}

    public void add_htc_to_wishlist(){
        clickElement(htc_wishlist_button);
    }
    public boolean wishlist_success_msg_isdisplayed(){
        wait_until_element_isDisplayed(wishlist_success_message);
        return is_displayed(wishlist_success_message);
    }
    public String get_success_message_color(){
        return get_element_cssValue(wishlist_success_message,"background-color");
    }
    public void open_wishlist(){
        wait_until_element_disappear(wishlist_success_message);
        clickElement(wishlist_tab);
    }
    public int get_wishlist_qty (){
        return get_int_attribute(wishlist_qty,"value");
    }

}
