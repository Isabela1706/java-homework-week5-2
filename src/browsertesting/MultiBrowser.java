package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * MultiBrowser
 */

public class MultiBrowser {
    static String browser = "Firefox";
    static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static WebDriver driver;

     public static void main(String[] args) {
       if(browser.equalsIgnoreCase("Chrome")){
        driver = new ChromeDriver();
       } else if (browser.equalsIgnoreCase("Firefox")) {
           driver = new FirefoxDriver();
       } else if (browser.equalsIgnoreCase("Edge")) {
           driver = new EdgeDriver();
       }else {
           System.out.println("Wrong browser");
       }
         //Open URL.
         driver.get(baseURL);
         //Maximise the Browser
         driver.manage().window().maximize();
         //We give Implicit wait to driver
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



         //Print the title of the page.
         System.out.println( "This is the title of the page " + driver.getTitle());

         //Print the current URL.
         System.out.println("Current URL is " + driver.getCurrentUrl());


         //Print the page source.
         System.out.println("Page Source " + driver.getPageSource());

         //Click on the ‘Forgot your password?’ link.
         WebElement forgetLink = driver.findElement(By.className("orangehrm-login-forgot-header"));
         forgetLink.click();


         //After forgot password current link
         String currentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
         System.out.println(driver.getCurrentUrl());


         //Navigate back to the login page.
         driver.navigate().to(baseURL);


         //Refresh the page.
         driver.navigate().refresh();


         //Enter the email in the email field.
         WebElement searchBox = driver.findElement(By.name("username"));
         searchBox.sendKeys("abc123@gmail.com");

         //Enter the password in the password field.
         WebElement searchField = driver.findElement(By.name("password"));
         searchField.sendKeys("1234567");

         //Click on the Login Button.
         WebElement loginLink = driver.findElement(By.className("orangehrm-login-button"));
         loginLink.click();





         //Close
         driver.close();
     }
}
