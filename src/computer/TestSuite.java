package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**● Create the package name computer
 1. Create class “TestSuite”
 Write the following Test:
 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 1.1 Click on Computer Menu.
 1.2 Click on Desktop
 1.3 Select Sort By position "Name: Z to A"
 1.4 Verify the Product will arrange in Descending order.
 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 2.1 Click on Computer Menu.
 2.2 Click on Desktop
 2.3 Select Sort By position "Name: A to Z"
 2.4 Click on "Add To Cart"
 2.5 Verify the Text "Build your own computer"
 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class 2.7.Select "8GB [+$60.00]" using Select class.
 2.8 Select HDD radio "400 GB [+$100.00]"
 2.9 Select OS radio "Vista Premium [+$60.00]"
 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
 2.11 Verify the price "$1,475.00"
 2.12 Click on "ADD TO CARD" Button.
 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
 After that close the bar clicking on the cross button.
 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button. 2.15 Verify the message "Shopping cart"
 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 2.17 Verify the Total"$2,950.00"
 2.18 click on checkbox “I agree with the terms of service”
 2.19 Click on “CHECKOUT”
 2.20 Verify the Text “Welcome, Please Sign In!”
 2.21Click on “CHECKOUT AS GUEST” Tab
 2.22 Fill the all mandatory field
 2.23 Click on “CONTINUE”
 2.24 Click on Radio Button “Next Day Air($0.00)”
 2.25 Click on “CONTINUE”
 2.26 Select Radio Button “Credit Card”
 2.27 Select “Master card” From Select credit card dropdown
 2.28 Fill all the details
 2.29 Click on “CONTINUE”
 2.30 Verify “Payment Method” is “Credit Card”
 2.32 Verify “Shipping Method” is “Next Day Air”
 2.33 Verify Total is “$2,950.00”
 2.34 Click on “CONFIRM”
 2.35 Verify the Text “Thank You”
 2.36 Verify the message “Your order has been successfully processed!” 2.37 Click on “CONTINUE”
 2.37 Verify the text “Welcome to our store”

 *
 */

public class TestSuite extends Utility {
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //define expected
        String expectedText = "Name: Z to A";
        //get actual
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
        //Verify the Product will arrange in Descending order.
        Assert.assertEquals("not sorted by Name: Z to A", expectedText, actualText);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        // Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //define expected text
        String expectedText = "Build your own computer";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        Assert.assertEquals("Not on Build your own computer page", expectedText, actualText);
        Thread.sleep(2000);
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[6]/dl[1]/dd[2]/select[1]"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        // Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(2000);
        //mouseHoverAndClickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //define expected price
        String expectedPrice = "$1,475.00";
        //get actual price
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        // Verify the price "$1,475.00"
        Assert.assertEquals("not $1,475.00", expectedPrice, actualPrice);
        //Click on "ADD TO CARD" Button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1'] "));
        //define expected
        String expectedMessage = "The product has been added to your shopping cart";
        //get actual
        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("Not added successfully", expectedMessage, actualMessage);
        //After that close the bar clicking on the cross button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //define expected
        String expectedTextShoppingCart = "Shopping cart";
        //get actual
        String actualTextShoppingCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //Verify the message "Shopping cart"
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
        Thread.sleep(2000);
        // Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        //define expected
        String expectedTotal = "$2,950.00";
        //get actual
        String actualTotal = getTextFromElement(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"));
        //Verify the Total"$2,950.00"
        Assert.assertEquals("Total not $2,950.00", expectedTotal, actualTotal);
        Thread.sleep(2000);
        //click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@name='termsofservice']"));
        // Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@name='checkout']"));
        //define expected text
        String expectedWelcome = "Welcome, Please Sign In!";
        //get actual text
        String actualWelcome = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(2000);
        Assert.assertEquals("Not on sign in page", expectedWelcome, actualWelcome);
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "DD");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "DD123@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "11 Danes Gate");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "UB4 2DA");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07321332451");
        // Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));
        //Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        // Fill all the details
        sendTextToElement(By.id("CardholderName"), "MRS D Patel");
        sendTextToElement(By.id("CardNumber"), "3256754579765121");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "333");
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // Verify “Payment Method” is “Credit Card”
        String expectedPaymenMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not credit card", expectedPaymenMethod, actualPaymentMethod);
        // Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Thread.sleep(2000);
        Assert.assertEquals("not next day air", expectedShippingMethod, actualShippingMethod);
        // Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        // Click on “CONFIRM”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //define expected
        String expectedThankYou = "Thank you";
        //get actual
        Thread.sleep(2000);
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //Verify the Text “Thank You”
        Thread.sleep(2000);
        Assert.assertEquals("Thank you not displayed", expectedThankYou, actualThankYou);
        //define expected
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        //get actual
        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Not processed", expectedSuccessfullyProcessed, actualSuccessfullyProcessed);
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text “Welcome to our store”
        String expectedWelcomeMessage = "Welcome to our store";
        //get actual
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        //Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);
    }


}
