package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    /*
    2. Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.

1. LoginTest

3. Write down the following test in the ‘LoginTest’ class
1. userShouldLoginSuccessfullyWithValidCredentials()

* Enter “tomsmith” for the username
* Enter “SuperSecretPassword!” for the
password
* Click on the ‘Login’ button
* Verify the text “Secure Area”
* Click on the ‘Logout’ button
* Verify the text ‘You logged out of the secure area!’

2. verifyTheUsernameErrorMessage()

* Enter “tomsmith1” for the username
* Enter “SuperSecretPassword!” for the
password
* Click on the ‘Login’ button
* Verify the error message “Your username is invalid!”

3. verifyThePasswordErrorMessage()

* Enter “tomsmith” for the username
* Enter “SuperSecretPassword” for the
password
* Click on the ‘Login’ button
* Verify the error message “Your password is invalid!”
     */
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void Open(){

        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Verifying the text Secure area
    String expectedText = "Secure Area";
    String actualText = driver.findElement(By.xpath("//h2")).getText();
    Assert.assertEquals("Secure Area",expectedText,actualText);
    //Click on Logout
    driver.findElement(By.linkText("Logout")).click();

    // Verify the text'you logged out of Secure Area
    String expectedText1 = "You logged out of the secure area!";
    String actualText1 = driver.findElement(By.id("flash")).getText();
    Assert.assertEquals("You logged out of the secure area!",expectedText1,actualText1);

        }
        @Test
public void verifyTheUsernameErrorMessage(){
    driver.findElement(By.id("username")).sendKeys("tomsmith1");
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

    // Verify the Error message 'your usename is invalid'
            String expectedText2 = "Your username is invalid!\n"+"×";
            String actualText2 = driver.findElement(By.id("flash")).getText();
            Assert.assertEquals(" Your username is invalid!",expectedText2,actualText2);

        }
        @Test
        public void verifyThePasswordErrorMessage(){
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

           //  Verify the Error message  'Your password is invalid!'
          String expectedText3 = "Your password is invalid!\n"+"×";
            String actualText3 = driver.findElement(By.id("flash")).getText();
          Assert.assertEquals(" Your password is invalid!",expectedText3,actualText3);

        }

       @After
       public void close(){
        closeBrowser();
        }
}
