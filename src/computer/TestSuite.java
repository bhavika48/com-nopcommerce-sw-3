package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //  select and Verify the Product will arrange in Descending order.
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Desktops"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        // wait for 3 seconds after select
        Thread.sleep(3000);


        List<WebElement> products = listOfItems(By.xpath("//div[@class='item-grid']//h2//a"));
        String product1 = products.get(0).getText();
        Assert.assertEquals("Lenovo IdeaCentre 600 All-in-One PC", product1);

        String product2 = products.get(1).getText();
        Assert.assertEquals("Digital Storm VANQUISH 3 Custom Performance PC", product2);

        String product3 = products.get(2).getText();
        Assert.assertEquals("Build your own computer", product3);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // verify products added to shopping cart
        // 2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        // 2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        // 2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        // wait for 3 seconds after select
        Thread.sleep(2000);
        // Verify the Product will arrange in Descending order.

        List<WebElement> products = listOfItems(By.xpath("//div[@class='item-grid']//h2//a"));
        String product1 = products.get(0).getText();
        //String product1 = getTextFromElement(By.xpath("//div[@class='item-grid']//h2//a[0]"));
        Assert.assertEquals("Build your own computer", product1);

        String product2 = products.get(1).getText();
        Assert.assertEquals("Digital Storm VANQUISH 3 Custom Performance PC", product2);


        String product3 = products.get(2).getText();
        Assert.assertEquals("Lenovo IdeaCentre 600 All-in-One PC", product3);

        //2.4 click on add to cart
        clickOnElement(By.xpath("//div[@class='item-grid']//button[@type='button' and text()='Add to cart'][1]"));
        // 2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Build your own computer']"));
        Assert.assertEquals(expectedMessage, actualMessage);

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
       // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//label[contains(text(),'400 GB [+$100.00]')]"));
       // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath(" //label[contains(text(),'Vista Premium [+$60.00]')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]')]"));
        Thread.sleep(2000);
        // 2.11 Verify the price "$1,475.00"
        String expectedMessage1 = "$1,475.00";
        String actualMessage1 = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar


        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        // close message
        clickOnElement(By.xpath("//span[@title='Close']"));

//        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHooverToElement(By.xpath("//span[@class='cart-label']"));

        //Shopping cart -------> GO TO CART and Click
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

//        2.15 Verify the message "Shopping cart"
        String expMessage4="Shopping cart";
        String actMessage4=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expMessage4,actMessage4);

        //        2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendKeysToElement(By.xpath("//input[@class='qty-input']"), "2");

        clickOnElement(By.id("updatecart"));
//        2.17 Verify the Total"$2,950.00"
        String expectedMessage4 = "$2,950.00";
        String actualMessage4 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong"));
        Assert.assertEquals(expectedMessage4, actualMessage4);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));

//        2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //  2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage5, actualMessage5);

        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        // 2.22 Fill the all mandatory field
        sendKeysToElement(By.id("BillingNewAddress_FirstName"), "Tom");
        sendKeysToElement(By.id("BillingNewAddress_LastName"), "Olins");
        sendKeysToElement(By.id("BillingNewAddress_Email"), "tom123@gmail.com");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "American Samoa");
        sendKeysToElement(By.id("BillingNewAddress_City"), "Texas");
        sendKeysToElement(By.id("BillingNewAddress_Address1"), "50 Cecli Road");
        sendKeysToElement(By.id("BillingNewAddress_ZipPostalCode"), "Tw3 4QP");
        sendKeysToElement(By.id("BillingNewAddress_PhoneNumber"), "04562341345");


//        2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

//        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[normalize-space()='Next Day Air ($0.00)']"));

//        2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//        2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));


//        2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");



//        2.28 Fill all the details
        sendKeysToElement(By.id("CardholderName"),"Tom");
        sendKeysToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
       sendKeysToElement(By.xpath("//input[@id='CardCode']"),"123");




      // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));


//        2.30 Verify “Payment Method” is “Credit Card”
        String expectedMessage6="Credit Card";
        String actualMessage6=getTextFromElement(By.xpath("//li[@class='payment-method']//span[@class='value']"));
        Assert.assertEquals(expectedMessage6,actualMessage6);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedMessage7="Next Day Air";
        String actualMessage7=getTextFromElement(By.xpath("//li[@class='shipping-method']//span[@class='value']"));
        Assert.assertEquals(expectedMessage7,actualMessage7);

//       2.33 Verify Total is “$2,950.00”
      String expectedMessage8="$2,950.00";
       String actualMessage8=getTextFromElement(By.xpath("//span[@class='value-summary']//strong"));
        Assert.assertEquals(expectedMessage8,actualMessage8);
//        2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

//        2.35 Verify the Text “Thank You”
        String expectedMessage9="Thank you";
        String actualMessage9=getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedMessage9,actualMessage9);

//        2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage11="Your order has been successfully processed!";
        String actualMessage11=getTextFromElement(By.xpath("//div[@class='page checkout-page order-completed-page']"));
        Assert.assertEquals(expectedMessage11,actualMessage11);
//        2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

//        2.37 Verify the text “Welcome to our store”
        String expectedMessage12="Welcome to our store";
        String actualMessage12=getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedMessage12,actualMessage12);


    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}
