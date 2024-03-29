package tests.loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateLockedUserError {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        WebElement failedMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String title = failedMessage.getText();
        Assert.assertEquals(title, "failure", "TEXT does not match");
        System.out.println("correct");
    }
}
