package tests.loginTests.positiveTests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateStandardUserLogin {

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
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html", "URL does not match" );
        WebElement titleProducts = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = titleProducts.getText();
        Assert.assertEquals(title, "Products", "TEXT does not match");
    }
}