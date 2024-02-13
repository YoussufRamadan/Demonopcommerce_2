package steDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P00_homePage;

import static steDefs.TestBase.driver;

public class D05_hoverCategoriesStepDef {
    P00_homePage homePage = new P00_homePage(driver);
    SoftAssert soft = new SoftAssert();

    @When("user hover on categories")
    public void user_hover_on_categories() {
        homePage.hoover_categories();

        /*List<WebElement> categories = homePage.find_category_list();
        // should use int i in for loop to deal with integers
        System.out.println(categories.size());
        for (int i=1; i< categories.size(); i++ ){
            // this step to create object to use actions methods
            Actions action = new Actions(driver);
            action.moveToElement(categories.get(i)).perform();
            soft.assertTrue(homePage.sublist_is_displayed());
        }*/

    }
    String selection1;
    @And("user click on random sub category")
    public void user_click_on_random_sub_category(){
       System.out.println( homePage.find_sublist().size());
       selection1 = homePage.select_random_subcat();
        System.out.println(selection1);


    }

    @Then("user is at sub category page")
    public void user_is_at_sub_category_page() {
        // to verify visible title contains same word you entered
        String pagetitle = homePage.getPageTitle();
        System.out.println(pagetitle);
        Assert.assertTrue(pagetitle.contains(selection1));
    }


}
