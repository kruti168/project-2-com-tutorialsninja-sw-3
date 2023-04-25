package myaccounts;

import org.checkerframework.checker.index.qual.GTENegativeOne;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");

        //1.3 Verify the text “Register Account"
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 click on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMenu("Login");

        //2.3 Verify the text “Returning Customer”.
        String expectedMessage1 = "Returning Customer";
        String actualMessage1 = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
       // 3.1 Clickr on My Account Link.

         clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");

//        3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"kruti");

//        3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"patel");

//        3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"kruti111111111@yahoo.com");

//        3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"01117779997");

//        3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Kruti123");

//        3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"Kruti123");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage2 = "Your Account Has Been Created!";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals(expectedMessage2, actualMessage2);

       // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter"LogOut"
        selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String expectedMessage3 = "Account Logout";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expectedMessage3, actualMessage3);

       // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // 4.1 Click on My Account Link.

        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOption("Login");

        // 4.3 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "kruti11111111@yahoo.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Kruti123");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

        //4.7 Verify text “My Account”
        String expectedMessage3 = "My Account";
        String actualMessage3 = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals(expectedMessage3, actualMessage3);

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter "Logot"

        selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        String expectedMessage4 = "Account Logout";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expectedMessage4, actualMessage4);


    }
    @After
    public void tearDown(){

        closeBrowser();
    }

}