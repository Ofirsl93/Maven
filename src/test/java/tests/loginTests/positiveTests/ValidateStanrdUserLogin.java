package tests.loginTests.positiveTests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateStanrdUserLogin {
public static void main(String[] args) {

     WebDriver driver = new ChromeDriver();
        validateUser(driver,"standard_user");
        validateUser(driver,"problem_user");
        validateUser(driver,"performance_glitch_user");
        validateUser(driver,"error_user");
        validateUser(driver,"visual_user");
        driver.quit();
    }

 public static void validateUser(WebDriver driver, String username){
        driver.get("https://www.saucedemo.com");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button"));

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html", "URL does not match" );
        WebElement titleProducts = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = titleProducts.getText();
        Assert.assertEquals(title, "Products", "TEXT does not match");

    }
}
