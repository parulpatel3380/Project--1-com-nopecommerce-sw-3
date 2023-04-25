package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.xpath;

/**● Create package Electronics
 1. Create the class ElectronicsTest
 Write the following test
 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully() 1.1 Mouse Hover on “Electronics” Tab
 1.2 Mouse Hover on “Cell phones” and click
 1.3 Verify the text “Cell phones”
 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() 2.1 Mouse Hover on “Electronics” Tab
 2.2 Mouse Hover on “Cell phones” and click
 2.3 Verify the text “Cell phones”
 2.4 Click on List View Tab
 2.5 Click on product name “Nokia Lumia 1020” link
 2.6 Verify the text “Nokia Lumia 1020”
 2.7 Verify the price “$349.00”
 2.8 Change quantity to 2
 2.9 Click on “ADD TO CART” tab
 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
 After that close the bar clicking on the cross button.
 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 2.12 Verify the message "Shopping cart"
 2.13 Verify the quantity is 2
 2.14 Verify the Total $698.00
 2.15 click on checkbox “I agree with the terms of service” 2.16 Click on “CHECKOUT”
 2.17 Verify the Text “Welcome, Please Sign In!”
 2.18 Click on “REGISTER” tab
 2.19 Verify the text “Register”
 2.20 Fill the mandatory fields
 2.21 Click on “REGISTER” Button
 2.22 Verify the message “Your registration completed” 2.23 Click on “CONTINUE” tab
 2.24 Verify the text “Shopping card”
 2.25 click on checkbox “I agree with the terms of service” 2.26 Click on “CHECKOUT”
 2.27 Fill the Mandatory fields
 2.28 Click on “CONTINUE”
 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 2.30 Click on “CONTINUE”
 2.31 Select Radio Button “Credit Card”
 2.32 Select “Visa” From Select credit card dropdown
 2.33 Fill all the details
 2.34 Click on “CONTINUE”
 2.35 Verify “Payment Method” is “Credit Card”
 2.36 Verify “Shipping Method” is “2nd Day Air”
 2.37 Verify Total is “$698.00”
 2.38 Click on “CONFIRM”
 2.39 Verify the Text “Thank You”
 2.40 Verify the message “Your order has been successfully processed!” 2.41 Click on “CONTINUE”
 2.42 Verify the text “Welcome to our store”
 2.43 Click on “Logout” link
 2.44 Verify the URL is “https://demo.nopcommerce.com/”

 *
 */


public class ElectronicsTest extends Utility {
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Hover over electronics
        mouseHoverToElement(xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        //click on cell phones
        clickOnElement(xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));
        //define expected
        String expectedCellPhoneText = "Cell phones";
        //get actual
        String actualCellPhonesText;
        actualCellPhonesText = getTextFromElement(xpath("//h1[contains(text(),'Cell phones')]"));
        //verify expected and actual are the same
        Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverToElement(xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        clickOnElement(xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        String expectedCellPhoneText = "Cell phones";
        String actualCellPhonesText = getTextFromElement(xpath("//div[@class='page-title']/h1"));
        Thread.sleep(2000);
        Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);
        // Click on List View Tab
        clickOnElement(xpath("//a[@class='viewmode-icon list']"));
        // Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(linkText("Nokia Lumia 1020"));
        //define expected
        String expectedNokia = "Nokia Lumia 1020";
        //get actual
        String actualNokia = getTextFromElement(xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"));
        // Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("not on nokia", expectedNokia, actualNokia);
        //define expected
        String expectedNokiaPrice = "$349.00";
        //get actual
        String actualNokiaPrice = getTextFromElement(xpath("//span[@id='price-value-20']"));
        // Verify the price “$349.00”
        Assert.assertEquals("Nokia price not $349.00", expectedNokiaPrice, actualNokiaPrice);
        // Change quantity to 2
        driver.findElement(xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
        //Click on “ADD TO CART” tab
        clickOnElement(xpath("//button[@class='button-1 add-to-cart-button']"));
        //define expected
        String expectedShoppingCartAdd = "The product has been added to your shopping cart";
        //get actual
        String actualShoppingCartAdd = getTextFromElement(xpath("//div[@class='bar-notification success']/p"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("not added", expectedShoppingCartAdd, actualShoppingCartAdd);
        //After that close the bar clicking on the cross button.
        clickOnElement(xpath("//div[@class='bar-notification success']/span"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(xpath("//span[@class='cart-label']"));
        clickOnElement(xpath("//button[@class='button-1 cart-button']"));
        //define expected
        String expectedTextShoppingCart = "Shopping cart";
        //get actual
        String actualTextShoppingCart = getTextFromElement(xpath("//div[@class='page-title']/h1"));
        // Verify the message "Shopping cart"
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
        WebElement text = driver.findElement(xpath("//input[@class='qty-input']"));
        String expectedText1 = "2";
        String actualText2 = text.getAttribute("value");
        Assert.assertEquals("not equal", expectedText1, actualText2);
        //define expected
        String expectedTotal = "$698.00";
        //get actual
        String actualTotal;
        actualTotal = getTextFromElement(xpath("//tbody/tr[1]/td[6]/span[1]"));
        Thread.sleep(2000);
        //Verify the Total $698.00
        Assert.assertEquals("not $698.00", expectedTotal, actualTotal);
        // click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(xpath("//button[@id='checkout']"));
        Thread.sleep(2000);
        //define expected text
        String expectedWelcome = "Welcome, Please Sign In!";
        //get actual text
        String actualWelcome = getTextFromElement(xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Not on sign in page", expectedWelcome, actualWelcome);
        // Click on “REGISTER” tab
        Thread.sleep(2000);
        //click on register button
        //mouseHoverToElement(By.xpath("//button[contains(text(),'Register')]"));
        clickOnElement(xpath("//button[contains(text(),'Register')]"));
        //define expected
        String expectedRegister = "Register";
        //get actual
        String actualRegister = getTextFromElement(xpath("//h1[text()='Register']"));
        // Verify the text “Register”
        Assert.assertEquals("Not registered", expectedRegister, actualRegister);
        // Fill the mandatory fields
        Thread.sleep(2000);
        //Enter First Name
        sendTextToElement(id("FirstName"), "Dhara");
        //Enter Last Name
        sendTextToElement(id("LastName"), "Patel");
        //Enter Date
        selectByVisibleTextFromDropDown(name("DateOfBirthDay"), "15");
        //Enter Month
        selectByVisibleTextFromDropDown(name("DateOfBirthMonth"), "July");
        //Enter Year
        selectByVisibleTextFromDropDown(name("DateOfBirthYear"), "1984");
        //Enter Email
        sendTextToElement(id("Email"), "D38patel125@gmail.com");
        //Enter Password
        sendTextToElement(id("Password"), "AimHigh123");
        //Enter Confirm password
        sendTextToElement(id("ConfirmPassword"), "AimHigh123");
        // Click on “REGISTER” Button
        clickOnElement(xpath("//button[@id='register-button']"));
        // Verify the message “Your registration completed”
        expectedText1 = "Your registration completed";
        actualText2 = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Registration ",expectedText1,actualText2);
        // Click on “CONTINUE” tab
        clickOnElement(xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);
        //print out statement
        System.out.println("bug!");
        System.out.println("Your Shopping Cart is empty!");
        Thread.sleep(2000);
        expectedText1 = "Shopping cart";
        actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Cart ",expectedText1,actualText2);
        mouseHoverAndClickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(xpath("//button[@id='checkout']"));
        Thread.sleep(3000);
        // Fill the Mandatory fields
        selectByVisibleTextFromDropDown(xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Alabama");
        Thread.sleep(2000);
        sendTextToElement(xpath("//input[@id='BillingNewAddress_City']"), "Bath");
        sendTextToElement(xpath("//input[@id='BillingNewAddress_Address1']"), "20 London Road");
        Thread.sleep(2000);
        sendTextToElement(xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "12376");
        Thread.sleep(2000);
        sendTextToElement(xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "569847555");
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        // Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnElement(xpath("//input[@id='shippingoption_2']"));
        // Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // Select Radio Button “Credit Card”
        clickOnElement(xpath("//input[@id='paymentmethod_1']"));
        //continue
        Thread.sleep(2000);
        clickOnElement(xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        // Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(xpath("//select[@id='CreditCardType']"), "Visa");
        // Fill all the details
        sendTextToElement(xpath("//input[@id='CardholderName']"), "Mrs DD Patel");
        sendTextToElement(xpath("//input[@id='CardNumber']"), "2544446356789234");
        selectByVisibleTextFromDropDown(xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(xpath("//input[@id='CardCode']"), "123");
        // Click on “CONTINUE”
        clickOnElement(xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //define expected
        String expectedCard = "Credit Card";
        //get actual
        String actualCard = getTextFromElement(xpath("//span[contains(text(),'Credit Card')]"));
        // Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Not credit card", expectedCard, actualCard);
        //define expected
        String expectedShippingMethod = "2nd Day Air";
        //get actual
        String actualShippingMethod = getTextFromElement(xpath("//li[@class='shipping-method']/span[@class='value']"));
        // Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("not 2nd day air", expectedShippingMethod, actualShippingMethod);
        //define expected
        String expectedTotalPrice = "$698.00";
        //get actual
        String actualTotalPrice = getTextFromElement(xpath("//tbody/tr[1]/td[6]/span[1]"));
        // Verify Total is “$698.00”
        Assert.assertEquals("Price not $698.00", expectedTotalPrice, actualTotalPrice);
        // Click on “CONFIRM”
        clickOnElement(xpath("//button[contains(text(),'Confirm')]"));
        // Verify the Text “Thank You”
        String expectedMessage14 = "Thank you";
        //Actual Message
        String actualMessage14 = getTextFromElement(xpath("//h1[text()='Thank you']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage14, actualMessage14);
        // Verify the message “Your order has been successfully processed!”
        String expectedMessage15 = "Your order has been successfully processed!";
        //Actual Message
        String actualMessage15 = getTextFromElement(xpath("//strong[text()='Your order has been successfully processed!']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage15, actualMessage15);
        // Click on “CONTINUE”
        clickOnElement(xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text “Welcome to our store”
        String expectedMessage16 = "Welcome to our store";
        //Actual Message
        String actualMessage16 = getTextFromElement(xpath("//h2[text()='Welcome to our store']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage16, actualMessage16);
        // Click on “Logout” link
        clickOnElement(xpath("//a[contains(text(),'Log out')]"));
        // Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage17, actualMessage17);
    }

}