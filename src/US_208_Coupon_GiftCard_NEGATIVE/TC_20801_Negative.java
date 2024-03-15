package US_208_Coupon_GiftCard_NEGATIVE;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_20801_Negative extends BaseDriver {
    @Test
    public void Test801(){
        Tools.LoginTest();

        //Step 3. In the homepage, click "14.1-inin Laptop" under "Notebook" from the "Computers" menu.

        WebElement computers=driver.findElement(By.xpath("(//a[contains(@href,'/computers')])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(computers)
                .build()
                .perform();
        Tools.Bekle(3);

        WebElement notebooks= driver.findElement(By.xpath("(//*[contains(@href,'/notebooks')])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(notebooks)
                .click()
                .build()
                .perform();

        WebElement notebook14Inch= driver.findElement(By.xpath("//*[@class='product-title']/a"));
        new Actions(driver)
                .moveToElement(notebook14Inch)
                .click()
                .build()
                .perform();

        //Step 4. On the product page, click the "Add to Cart" button to add the product to the basket.
        WebElement addToCart= driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(addToCart)
                .click()
                .build()
                .perform();

        //Step 5. Click the "Shopping Cart" button to navigate to your basket.  (//*[@class='cart-label'])[1]
        WebElement shoppingCart= driver.findElement(By.xpath("(//*[@href='/cart'])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(shoppingCart)
                .click()
                .build()
                .perform();


        //Step 6. Click the "Apply Coupon" button (Use Coupon) (click on
        //the Coupon Code If you do not enter the code).
        WebElement applyCoupon= driver.findElement(By.name("applydiscountcouponcode"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(applyCoupon)
                .click()
                .build()
                .perform();

        //Step 7. Verify that there is no coupon code to be used.
        WebElement couponMessage=driver.findElement(By.xpath("//*[@class='message']"));
        if(couponMessage.getText().contains("The coupon code you entered couldn't be applied to your order")) {
            System.out.println("It is confirmed that there were no coupons.");
        } else {
            System.out.println("No coupon could not be verified.");
        }

        //Step 8. Click the "Add gift card" button (If you do not enter the code).
        WebElement addGiftCard= driver.findElement(By.name("applygiftcardcouponcode"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(addGiftCard)
                .click()
                .build()
                .perform();
        //Step 9. Verify that there is no Gift Card to be used.
        WebElement GiftCardMessage=driver.findElement(By.xpath("//*[@class='message']"));
        Tools.Bekle(2);
        if(GiftCardMessage.getText().contains("The coupon code you entered couldn't be applied to your order")) {
            System.out.println("It has been confirmed that there was no Gift Card.");
        } else {
            System.out.println("No Gift Card NOT VERIFIED.");
        }
            //Step 10. Fill the necessary information for the cargo details:
        Actions dAct =new Actions(driver);

        WebElement country = driver.findElement(By.cssSelector("select[name='CountryId']"));
        Select countrySel = new Select(country);
        countrySel.selectByValue("77");
        dAct.moveToElement(driver.findElement(By.xpath("//select[@id='StateProvinceId']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//input[@id='ZipPostalCode']"))).click().sendKeys("07000").build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[name='termsofservice']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.xpath("//button[@class='button-1 checkout-button']"))).click().build().perform();

        List<WebElement> addInformation = driver.findElements(By.cssSelector("label[for='billing-address-select']"));
        if (!addInformation.isEmpty()) {
            dAct.click(driver.findElement(By.cssSelector("input[onclick='Billing.save()']"))).build().perform();
        } else {
            WebElement country2 = driver.findElement(By.cssSelector("select[id='BillingNewAddress_CountryId']"));
            Select countrySel2 = new Select(country2);
            countrySel2.selectByValue("77");
            dAct.moveToElement(driver.findElement(By.cssSelector("select[name='BillingNewAddress.StateProvinceId']"))).click().build().perform();
            dAct.moveToElement(driver.findElement(By.cssSelector("input[name='BillingNewAddress.City']"))).click().sendKeys("Antalya").build().perform();
            dAct.moveToElement(driver.findElement(By.xpath("//input[@name='BillingNewAddress.Address1']"))).click().sendKeys("Türkiye").build().perform();
            dAct.moveToElement(driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"))).click().sendKeys("07000").build().perform();
            dAct.moveToElement(driver.findElement(By.cssSelector("input[data-val-required='Phone is required']"))).click().sendKeys("0007 007 07 07").build().perform();
            dAct.click(driver.findElement(By.xpath("//input[@onclick='Billing.save()']"))).build().perform();
        }

        dAct.click(driver.findElement(By.cssSelector("input[onclick='Shipping.togglePickUpInStore(this)']"))).build().perform();
        dAct.click(driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"))).build().perform();
        Tools.Bekle(3);

        dAct.moveToElement(driver.findElement(By.cssSelector("input[id='paymentmethod_2']"))).click().build().perform();
        dAct.moveToElement(driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"))).click().build().perform();
        Tools.Bekle(3);

        dAct.click(driver.findElement(By.xpath("//input[@name='CardholderName']"))).sendKeys("Test Bugbusters").build().perform();
        dAct.click(driver.findElement(By.cssSelector("input[id='CardNumber']"))).sendKeys("4242 4242 4242 4242").build().perform();
        Select dateM = new Select(driver.findElement(By.id("ExpireMonth")));
        dateM.selectByValue("1");
        Select dateY = new Select(driver.findElement(By.id("ExpireYear")));
        dateY.selectByValue("2032");
        dAct.click(driver.findElement(By.xpath("//input[@name='CardCode']"))).sendKeys("123").build().perform();
        dAct.click(driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"))).build().perform();

        dAct.scrollToElement(driver.findElement(By.cssSelector("div[class='footer-menu-wrapper']"))).build().perform();

        WebElement subTotal = driver.findElement(By.cssSelector("td[class='cart-total-right']>span>span"));
        WebElement total = driver.findElement(By.cssSelector("span[class='product-price order-total']"));

        if (subTotal.getText().equals(total.getText())) {
            dAct.click(driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"))).build().perform();
            WebElement message = driver.findElement(By.xpath("//div[@class='title']/strong"));
            Assert.assertTrue(message.getText().contains("Your order has been successfully processed!"), "Helper text doesn't appear.");
        } else {
            System.out.println("The total price of the product is not equal to the calculated sum.");
        }
    }

}
