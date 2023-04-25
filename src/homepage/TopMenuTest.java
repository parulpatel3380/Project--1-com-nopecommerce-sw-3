package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * baseUrl: https://demo.nopcommerce.com/
 * Requirement:
 * ● Create the package homepage
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

public class TopMenuTest extends Utility {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyPageNavigationToMenu() {

    }

    /*
    1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    string
     */
    public static void selectMenu(String menu) {
        //create a list to store all menu options
        List<WebElement> menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        try {
            //loop through list with for loop
            for (WebElement menuOption : menuList) {
                System.out.println(menuOption.getText());
                //if option matches with the parameter then click
                if (menuOption.getText().equals(menu)) {
                    menuOption.click();
                }
            }
            //catch exceptions
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        }
    }

    /*
    This method should click on the menu whatever name is passed as parameter.
     */
    @Test
    public void verifyPageNavigation() throws InterruptedException {
        //call selectMenu method with parameter books
        selectMenu("Books");
        //define expected
        String expectedPage = "Books";
        //get actual
        String actualPage = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        //verify expected and actual are same
        Assert.assertEquals("page relocation fail", expectedPage, actualPage);
    }

    /*
    create the @Test method name verifyPageNavigation.use selectMenu method to
    select the Menu and click on it and verify the page navigation.
     */
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        clickOnElement(By.linkText("Computers"));

    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        clickOnElement(By.linkText("Electronics"));

    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        clickOnElement(By.linkText("Apparel"));

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfull() {
        clickOnElement(By.linkText("Digital downloads"));}


    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        clickOnElement(By.linkText("Books"));}


    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        clickOnElement(By.linkText("Jewelry"));

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        clickOnElement(By.linkText("Gift Cards"));

    }





}







