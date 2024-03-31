package tests.loginTests.negativeTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateLockedUserError {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        // first attempt Wait for the username input field
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        username.sendKeys("locked_out_user");

        // Wait for the password input field
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        password.sendKeys("secret_sauce");

        //  Wait for the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();

        WebElement failedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title = failedMessage.getText();
        Assert.assertEquals(title, "Epic sadface: Sorry, this user has been locked out.", "TEXT does not match");

        // Clear username and password fields
        username.clear();
        password.clear();

       //second attempt
        WebElement username2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        username2.sendKeys("incorrectUser");
        WebElement password2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        password2.sendKeys("secret_sauce");
        loginButton.click();

        WebElement failedMessage2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title2 = failedMessage2.getText();
        Assert.assertEquals(title2, "Epic sadface: Username and password do not match any user in this service", "TEXT does not match");

       username2.clear();
       password2.clear();

        //third attempt
        WebElement usernameInput3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        usernameInput3.sendKeys("incorrectUser");
        WebElement passwordInput3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        passwordInput3.sendKeys("incorrectPassword");
        loginButton.click();
        usernameInput3.clear();
        passwordInput3.clear();

        WebElement failedMessage3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title3 = failedMessage3.getText();
        Assert.assertEquals(title3, "Epic sadface: Username and password do not match any user in this service", "TEXT does not match");


        //fourth attempt
        WebElement usernameInput4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        usernameInput4.sendKeys("");
        WebElement passwordInput4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        passwordInput4.sendKeys("secret_sauce");
        loginButton.click();
        usernameInput4.clear();
        passwordInput4.clear();

        WebElement failedMessage4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title4 = failedMessage4.getText();
        Assert.assertEquals(title4, "Epic sadface: Username and password do not match any user in this service", "TEXT does not match");

        //fifth attempt
        WebElement username5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        username5.sendKeys("locked_out_user");
        WebElement password5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        password5.sendKeys("");
        username5.clear();
        password5.clear();

        WebElement failedMessage6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title6 = failedMessage6.getText();
        Assert.assertEquals(title6, "Epic sadface: Username and password do not match any user in this service", "TEXT does not match");

        //Sixth attempt
        WebElement username6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-name")));
        username6.sendKeys("");
        WebElement password6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password")));
        password6.sendKeys("");
        username6.clear();
        password6.clear();

        WebElement failedMessage5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        String title5 = failedMessage5.getText();
        Assert.assertEquals(title5, "Epic sadface: Username and password do not match any user in this service", "TEXT does not match");
        driver.quit();

    }
}

