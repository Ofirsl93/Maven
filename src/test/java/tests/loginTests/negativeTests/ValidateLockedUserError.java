package tests.loginTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class ValidateLockedUserError {
    public static void main(String[] args) {
      WebDriver driver = new ChromeDriver();

      validateLockedUsers(driver, "standard_user", "invalid_password", "Epic sadface: Username and password do not match any user in this service");
      validateLockedUsers(driver, "invalid_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service");
      validateLockedUsers(driver, "invalid_user", "invalid_password", "Epic sadface: Username and password do not match any user in this service");
      validateLockedUsers(driver, "", "secret_sauce", "Epic sadface: Username is required");
      validateLockedUsers(driver, "standard_user", "", "Epic sadface: Password is required");
      validateLockedUsers(driver, "", "", "Epic sadface: Username is required");
       driver.quit();
}
     public static void validateLockedUsers(WebDriver driver,String username ,String password, String expectedErrorMessage){
       driver.get("https://www.saucedemo.com");
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "Something went wrong.");

       WebElement userName = driver.findElement(By.id("user-name"));
       WebElement Password = driver.findElement(By.id("password"));

       userName.sendKeys(username);
       Password.sendKeys(password);
       driver.findElement(By.cssSelector("#login-button")).click();

       WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
       Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Login scenario failed for username: " + username + ", password: " + password);

       driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
       driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
       WebElement loginButton = driver.findElement(By.id("login-button"));
       loginButton.click();

       WebElement failedMessage = driver.findElement(By.cssSelector("[data-test='error']"));
       String title = failedMessage.getText();
       Assert.assertEquals(title, "Epic sadface: Sorry, this user has been locked out.", "TEXT does not match");
}
}
