package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl =  "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException{

       // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement laptopsNotebooks = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopsNotebooks.click();

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        List<WebElement> loadedPrices = driver.findElements(By.className("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/p[2]/text()"));
        List<Double> beforePriceSorting = new ArrayList<>();
        for (WebElement e : loadedPrices) {
            beforePriceSorting.add(Double.valueOf(e.getText().replace("$", "")));
        }
        WebElement dropDown = dropDownMenu(By.xpath("//*[@id=\"input-sort\"]"));
        Select select = new Select(dropDown);
        //Thread.sleep(2000);
        select.selectByVisibleText("Price (High > Low)");

        List<WebElement> sortedPrices = driver.findElements(By.className("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/p[2]/text()"));
        List<Double> afterPriceSorting = new ArrayList<>();
        for (WebElement e : sortedPrices) {
            afterPriceSorting.add(Double.valueOf(e.getText().replace("$", "")));
        }
        Collections.sort(beforePriceSorting);
        Thread.sleep(3000);
        Assert.assertEquals(afterPriceSorting,beforePriceSorting);

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{

        // 2.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement laptopsNotebooks = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopsNotebooks.click();

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));


        //2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = dropDownMenu(By.xpath("//*[@id=\"input-sort\"]"));
        Select select = new Select(dropDown);
        //Thread.sleep(2000);
        select.selectByVisibleText("Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //2.5 Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = getTextFromElement(By.linkText("MacBook"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage,actualMessage);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedMessage1 = "Success: You have added MacBook to your shopping cart!\n×";
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage1,actualMessage1);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the text "Shopping Cart"
        String expectedMessage2 = "Shopping Cart";
        String actualMessage2 = getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage2,actualMessage2);

        //2.10 Verify the Product name "MacBook"
        String expectedMessage3 = "MacBook";
        String actualMessage3 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage3,actualMessage3);

        //2.11 Change Quantity "2
       clearQty(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
       sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

       //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMessage4 = "Success: You have modified your shopping cart!\n×";
        String actualMessage4 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage4,actualMessage4);

        //2.14 Verify the Total £737.45
        String expectedMessage5 = "$1,204.00";
        String actualMessage5 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage5,actualMessage5);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text “Checkout”
        String expectedMessage6 = "Checkout";
        String actualMessage6 = getTextFromElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage6,actualMessage6);

        //2.17 Verify the Text “New Customer
        String expectedMessage7 = "New Customer";
        String actualMessage7 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage7,actualMessage7);

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"kruti");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"patel");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"kruti111@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"01112223334");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"123");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-2']"),"diamond road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"watford");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"wd24 5hd");



        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']")));
        select1.selectByVisibleText("United Kingdom");
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
        select2.selectByVisibleText("Greater London");


       //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"),"Hi I am Kruti");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

//        //2.25 Verify the message “Warning: Payment method required!
//        String expectedMessage8 = "Warning: No Payment options are available. Please contact us for assistance!";
//        String actualMessage8 = getTextFromElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"));
//        Thread.sleep(2000);
//         Assert.assertEquals(expectedMessage8,actualMessage8);

        //2.25 Verify the message “Warning: Payment method required!
        String expectedMessage8 = "Warning: Payment method required!\n×";
        String actualMessage8 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage8,actualMessage8);

    }
    @After
    public void tearDown(){

        closeBrowser();
    }

}
