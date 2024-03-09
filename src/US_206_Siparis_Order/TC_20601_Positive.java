package US_206_Siparis_Order;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_20601_Positive extends BaseDriver {
    @Test
    public void test() {
//        1. Open the web browser and navigate to "Demowebshop.tricentis.com ".
//        2. If the user session is not open, log in (log in).
        Tools.LoginTest();
//        3. In the homepage, click "14.1-inin Laptop" under
//        "Notebook" from the "Computers" menu.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");


//        4. On the product page, click the "Add to Cart" button to add
//        the product to the basket.
        driver.findElement(By.xpath("(//div[@class='product-item'])[2]//input")).click();
//        5. Click the "Shopping Cart" button to navigate to your basket.
        driver.findElement(By.xpath("((//div[@class='header-links'])//li)[3]/a")).click();
//        6. Fill the necessary information for the cargo details:
        driver.findElement(By.id("CountryId")).click();
//        7. Choose a country and state.
        driver.findElement(By.cssSelector("[value='77']")).click();
//        8. Accept the conditions.
        driver.findElement(By.id("termsofservice")).click();
//        9. Click the "Checkout" (payment) button to navigate to the
//        payment page.
        driver.findElement(By.id("checkout")).click();
//        10. Fill the payment information and confirm the order.
        driver.findElement(By.id("BillingNewAddress_CountryId")).click();
        driver.findElement(By.cssSelector("[value='77']")).click();
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Test");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Test");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123321");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567489");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        11. Verify the message "Your order has been successfully

        Tools.Bekle(10);
        driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();
        Tools.Bekle(2);

        driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']")).click();
        Tools.Bekle(2);

        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input")).click();
        Tools.Bekle(2);

        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
        Tools.Bekle(2);

        driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/input")).click();
        Tools.Bekle(2);

//        processed" ("Your Order Has Been SuccessFully
//        Processed!").
        WebElement OrderNumber= driver.findElement(By.xpath("(//div[@class='section order-completed']//li)[1]"));
        System.out.println(OrderNumber.getText());
//        12. Verify that the order number exists on the Orders link on
//        the home page. [For example: Order #1499948].
        Assert.assertFalse(OrderNumber.getText().isEmpty(), "Error: Order number is not displayed.");




    }

}
