package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl =  "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        WebElement desktops = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktops.click();

        //1.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");


        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order
//        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.id("input-sort"));
//        List<Double> beforeFileNameZtoAList= new ArrayList<>();
//        for(WebElement nameZtoA : beforeFilterNameZtoAList)
//        {
//            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
//        }
//
//        //select.selectByVisibleText("Name (Z - A)");
//       // select.selectByVisibleText("Name (Z - A)");
//
//        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.id("input-sort"));
//        List<Double>afterFileNameZtoAList = new ArrayList<>();
//        for(WebElement nameZtoA : afterFilterNameZtoAList)
//        {
//            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
//        }
//        Collections.sort(beforeFileNameZtoAList);
//        Assert.assertEquals(beforeFilterNameZtoAList,afterFilterNameZtoAList);


    }@Test
    public void verifyProductAddedToShoppingCartSuccessFully ()throws InterruptedException{
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktops = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktops.click();

        //2.1 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        selectMenu("HP LP3065");

        //2.5 Verify the Text "HP LP3065"
        String expectedMessage = "HP LP3065";
        String actualMessage = getTextFromElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals(expectedMessage,actualMessage);

        //2.6 Select Delivery Date "2022-11-30
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        //clickOnElement(By.id("input-option225"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            //System.out.println(monthYear); // November 2022
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")); // /html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[5]/td[3]"));
        for (WebElement dt : allDates){
            if (dt.getText().equalsIgnoreCase(date)){
                dt.click();
                break;
            }
        }

        //2.7.Enter Qty "1” using Select class.
        clearQty(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage2 = "Success: You have added HP LP3065 to your shopping cart!\n×";
        String actualTextMessage2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage2,actualTextMessage2);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        String expectedMessage5 = "Shopping Cart";
        String actualMessae5 = getTextFromElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[4]/a[1]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage5,actualMessae5);

        //2.12 Verify the Product name "HP LP3065"
        String expectedMessage6 = "HP LP3065";
        String actualMessae6 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage6,actualMessae6);

        //2.13 Verify the Delivery Date "2022-11-30"
        String expectedMessage7 = "Delivery Date:2022-11-30";
        String actualMessae7 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage7,actualMessae7);

        //2.14 Verify the Model "Product21"
        String expectedMessage8 ="Product 21";
        String actualTextMessage8 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage8,actualTextMessage8);

        //2.15 Verify the Todat "$122.00"
        String expectedMessage9 ="$122.00";
        String actualTextMessage9 = getTextFromElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]"));
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage9,actualTextMessage9);



    }
    public void tearDown(){

        closeBrowser();
    }


}
