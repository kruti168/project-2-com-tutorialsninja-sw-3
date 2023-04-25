package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    //This method will hoover element
    public WebElement mouseHover(By by) {

        return driver.findElement(by);
    }

    //This method should click on the menu
    public void selectMenu(String menu) {

        driver.findElement(By.linkText(menu)).click();

    }

       //This method should click on the options
        public void selectMyAccountOption(String option)
        {
        Actions actions = new Actions(driver);
        WebElement listGrouo= driver.findElement(By.linkText(option));
        actions.moveToElement(listGrouo).click().build().perform();
}


    //This method will get text from element
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    //This method will open dropDown Menu.
    public WebElement dropDownMenu(By by) {
        return driver.findElement(by);
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will be clear the qty.
    public void clearQty(By by) {
        driver.findElement(by).clear();
    }

    //This method will send text to element
    public void sendTextToElement(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }
}