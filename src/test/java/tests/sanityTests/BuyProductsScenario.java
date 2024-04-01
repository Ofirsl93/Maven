package tests.sanityTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.testng.Assert;
public class BuyProductsScenario {

   public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
     driver.get("https://www.saucedemo.com/");
     driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
     driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
     driver.findElement(By.cssSelector("#login-button")).click();

     String currentURL = driver.getCurrentUrl();
     Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html",  "URL does not match");

     WebElement titleProducts = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
     String title = titleProducts.getText();
     Assert.assertEquals(title, "Products", "TEXT does not match");

     driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
     driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();

     int twoNumbers = Integer.parseInt(driver.findElement(By.cssSelector("#shopping_cart_container > a")).getText());
     Assert.assertEquals(twoNumbers, 2, "NUMBER does not match");
     driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

     String currentURL1 = driver.getCurrentUrl();
     Assert.assertEquals(currentURL1,"https://www.saucedemo.com/cart.html", "URL does not match" );

     WebElement titleCart = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
     String cart = titleCart.getText();
     Assert.assertEquals(cart, "Your Cart", "TEXT does not match");

     List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
     int NumberOfItems = 2;
     Assert.assertEquals(NumberOfItems, cartItems.size(),"Number of items in cart does not match");

     driver.findElement(By.cssSelector("#checkout")).click();

     String currentURL2 = driver.getCurrentUrl();
     Assert.assertEquals(currentURL2,"https://www.saucedemo.com/checkout-step-one.html", "URL does not match");

     WebElement checkout = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
     String check = checkout.getText();
     Assert.assertEquals(check, "Checkout: Your Information", "TEXT does not match");

     driver.findElement(By.cssSelector("#first-name")).sendKeys("ofir");
     driver.findElement(By.cssSelector("#last-name")).sendKeys("slavuzki");
     driver.findElement(By.cssSelector("#postal-code")).sendKeys("752362");
     driver.findElement(By.cssSelector("#continue")).click();

     String currentURL3 = driver.getCurrentUrl();
     Assert.assertEquals( currentURL3,"https://www.saucedemo.com/checkout-step-two.html", "URL does not match");

     WebElement overview = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
     String CheckoutOverview = overview.getText();
     Assert.assertEquals(CheckoutOverview,"Checkout: Overview", "TEXT does not match");
     driver.findElement(By.cssSelector("#finish")).click();

     String currentURL4 = driver.getCurrentUrl();
     Assert.assertEquals(currentURL4,"https://www.saucedemo.com/checkout-complete.html", ": URL does not match");

     WebElement checkoutComplete = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
     String complete = checkoutComplete.getText();
     Assert.assertEquals(complete, "Checkout: Complete!", "TEXT does not match");

     WebElement thankYou = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
     String thank = thankYou.getText();
     Assert.assertEquals(thank,"Thank you for your order!", "TEXT does not match");

     WebElement yourOrder = driver.findElement(By.cssSelector("#checkout_complete_container > div"));
     String pony = yourOrder.getText();
     Assert.assertEquals(pony,"Your order has been dispatched, and will arrive just as fast as the pony can get there!", "TEXT does not match");
     driver.quit();
}
}
