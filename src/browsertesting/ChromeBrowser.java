package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Set up Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the ‘Forgot your password?’ link.
 * 7. Print the current URL.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email in the email field.
 * 11. Enter the password in the password field.
 * 12. Click on the Login Button.
 * 13. Close the browser.
 */

public class ChromeBrowser {

    static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public static void main(String[] args) {

        //Set up Chrome browser.
        WebDriver driver = new ChromeDriver();
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
