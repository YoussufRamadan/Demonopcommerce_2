package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageBase {
    WebDriver driver;

    public PageBase(WebDriver driver) {this.driver = driver;
    }
    void enterText (By webElement, String Text){
    driver.findElement(webElement).sendKeys(Text);
    }


    public void clickElement (By webElement){
        driver.findElement(webElement).click();
    }
    void scroll (By webElement){
        WebElement element = driver.findElement(webElement);
        String script = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor) driver).executeScript(script,element);
    }

    public String getURL (){
        return driver.getCurrentUrl();
    }

    public String getPageTitle (){
        return driver.getTitle();
    }
    public  void selectElement_byValue(By webelement,String selection){
        Select element= new Select(driver.findElement(webelement));
        element.selectByValue(selection);
    }
    public  void selectElement_byVisible(By webelement,String selection){
        Select element= new Select(driver.findElement(webelement));
        element.selectByVisibleText(selection);
    }
    public String getElementText (By webelement){ // you forgot this >> use getText instead of get cssvalue
       return driver.findElement(webelement).getText();

    }
    public boolean is_displayed(By webelement){
        return driver.findElement(webelement).isDisplayed();
    }

    public  void scroll_to_element (By webelement){
        WebElement element = driver.findElement(webelement); // this object hase role to find the web element
        String script = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }
    public List<WebElement> find_list_of_elements(By webelement){
       return driver.findElements(webelement) ; //find elementsss
    }
    public void hover_on_list(List<WebElement> webElements){
        Actions action = new Actions(driver); // important take care
        for(int i=0; i<webElements.size();i++){
            action.moveToElement(webElements.get(i)).perform();
        }
    }


    public void wait_until_number_of_tabs(int tabs){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabs));
    }
    public void switch_tabs (int tabNumber){
        // this array to collect all opened windows in an Array
        ArrayList<String> tabs =new  ArrayList<>(driver.getWindowHandles());
        System.out.println("there are "+ tabs.size()+" tabs");
        // this line to switch to the tab you want (tabNumber)
        driver.switchTo().window(tabs.get(tabNumber));

    }
    public String get_element_cssValue(By webelement,String property){
        return driver.findElement(webelement).getCssValue(property);
    }
    public void wait_until_element_isDisplayed(By webelement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf (driver.findElement(webelement)));
    }
    public void wait_until_element_disappear(By webelement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(webelement)));

    }
    public int get_int_attribute(By webelement,String attribute){
        String str_value = driver.findElement(webelement).getAttribute(attribute);
        return Integer.parseInt(str_value);
    }




}
