package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    /*
    BaseUrl = http://the-internet.herokuapp.com/login
1. Create the package ‘browserfactory’ and create the
class with the name ‘BaseTest’ inside the
‘browserfactory’ package. And write the browser setup
code inside the class ‘Base Test’.

     */

     public static WebDriver driver;

     public void openBrowser(String baseUrl){
driver = new ChromeDriver();
         driver.get(baseUrl);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


     }

     public void closeBrowser(){
         driver.quit();
     }
}
