package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHooverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Thread.sleep(2000);
        // 1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //  1.3 Verify the text “Cell phones”
        String expMessage="Cell phones";
        String actMessage=this.getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expMessage,actMessage);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHooverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
       Thread.sleep(2000);
        // 1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        // 2.3 Verify the text “Cell phones”
        String expMessage="Cell phones";
        String actMessage=getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals(expMessage,actMessage);

        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(3000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        //  2.6 Verify the text “Nokia Lumia 1020”
        String expMessage1= "Nokia Lumia 1020";
        String actMessage1=getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        Assert.assertEquals(expMessage1,actMessage1);

        //  2.7 Verify the price “$349.00”
        String expMessage2="$349.00";
        String actMessage2=getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expMessage2,actMessage2);

        //2.8 Change quantity to 2
        sendKeysToElement(By.id("product_enteredQuantity_20"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expMessage3="The product has been added to your shopping cart";
        String actMessage3=getTextFromElement(By.xpath("//div[@class='bar-notification success']"));
        Assert.assertEquals(expMessage3,actMessage3);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        //TODO: Need to Fix


        //        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHooverToElement(By.xpath("//span[@class='cart-label']"));

        //Shopping cart -------> GO TO CART and Click
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //driver.navigate().to("https://demo.nopcommerce.com/cart");

        //2.12 Verify the message "Shopping cart"
        String expMessage4="Shopping cart";
        String actMessage4=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expMessage4,actMessage4);

        //2.13 Verify the quantity is 2
        String expMessage5="2";
        //String actMessage5=getTextFromElement(By.xpath("//input[@class='qty-input']"));
        String actMessage5=getAttributeValueFromElement(By.xpath("//input[@class='qty-input']"));
        Assert.assertEquals(expMessage5,actMessage5);

        //2.14 Verify the Total $698.00
        String expMessage6="$698.00";
        String actMessage6=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expMessage6,actMessage6);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));


        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));


        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage5, actualMessage5);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        String expMessage7="Register";
        String actMessage7=getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        Assert.assertEquals(expMessage7,actMessage7);

        //2.20 Fill the mandatory fields
        sendKeysToElement(By.id("FirstName"),"Ann");
        sendKeysToElement(By.id("LastName"),"Martin");
        sendKeysToElement(By.id("Email"),"ann456@gmail.com");
        sendKeysToElement(By.id("Password"),"ann123");
        sendKeysToElement(By.id("ConfirmPassword"),"ann123");

        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //  2.22 Verify the message “Your registration completed”
        String expMessage8="Your registration completed";
        String actMessage8=getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(expMessage8,actMessage8);

        //  2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

        //   2.24 Verify the text “Shopping card”
        String expMessage9="Shopping cart";
        String actMessage9=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expMessage9,actMessage9);

        //TODO: found bug
        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to')]"));


        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        sendKeysToElement(By.id("BillingNewAddress_FirstName"), "Tom");
        sendKeysToElement(By.id("BillingNewAddress_LastName"), "Olins");
        sendKeysToElement(By.id("BillingNewAddress_Email"), "tom123@gmail.com");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "American Samoa");
        sendKeysToElement(By.id("BillingNewAddress_City"), "Texas");
        sendKeysToElement(By.id("BillingNewAddress_Address1"), "50 Cecli Road");
        sendKeysToElement(By.id("BillingNewAddress_ZipPostalCode"), "Tw3 4QP");
        sendKeysToElement(By.id("BillingNewAddress_PhoneNumber"), "04562341345");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[normalize-space()='2nd Day Air ($0.00)']"));

        // 2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");



        //2.33 Fill all the details
        sendKeysToElement(By.id("CardholderName"),"Ann");
        sendKeysToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendKeysToElement(By.xpath("//input[@id='CardCode']"),"123");


        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedMessage6="Credit Card";
        String actualMessage6=getTextFromElement(By.xpath("//li[@class='payment-method']//span[@class='value']"));
        Assert.assertEquals(expectedMessage6,actualMessage6);


        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMessage7="2nd Day Air";
        String actualMessage7=getTextFromElement(By.xpath("//li[@class='shipping-method']//span[@class='value']"));
        Assert.assertEquals(expectedMessage7,actualMessage7);
        //2.37 Verify Total is “$698.00”
        String expectedMessage8="$698.00";
        String actualMessage8=getTextFromElement(By.xpath("//span[@class='value-summary']//strong"));
        Assert.assertEquals(expectedMessage8,actualMessage8);


        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        String expectedMessage9="Thank you";
        String actualMessage9=getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedMessage9,actualMessage9);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage10="Your order has been successfully processed!";
        String actualMessage10=getTextFromElement(By.xpath("//div[@class='page checkout-page order-completed-page']"));
        Assert.assertEquals(expectedMessage10,actualMessage10);
        // 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        // 2.42 Verify the text “Welcome to our store”
        String expectedMessage12="Welcome to our store";
        String actualMessage12=getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedMessage12,actualMessage12);

        //  2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl= "https://demo.nopcommerce.com/";
       String actualUrl = getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);


    }



    @After
    public void tearDown(){
        closeBrowser();
    }

}
