package homepage;

import browserfactory.BaseTest;

import junit.runner.BaseTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
   String baseUrl= "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void selectMenu( String menu){
        clickOnElement(By.linkText(menu));
    }


    @Test
    public void verifyPageNavigation(){
        // click on menu
        clickOnElement(By.linkText("Computers"));
        String expectedMessage="Computers";
        String actualMessage=getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals("computrs is not displayed",expectedMessage,actualMessage);

    }



    @After
    public void tearDown(){
       closeBrowser();
    }



}
