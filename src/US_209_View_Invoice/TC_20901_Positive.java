package US_209_View_Invoice;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC_20901_Positive extends BaseDriver {
    @Test
    public void test9() {
        //Step 1. Open the web browser and navigate to "Demowebshop.tricentis.com".
    Tools.LoginTest();
        Tools.Bekle(3);
//Step 3. Navigate to the "My Account" page by clicking on your username or e-mail address on the homepage.
        WebElement myAccount = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(myAccount)
                .click()
                .build()
                .perform();
        //Step 4. View your orders by clicking on the "Orders" (Orders) link.
        WebElement orders = driver.findElement(By.xpath("(//*[@href='/customer/orders'])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(orders)
                .click()
                .build()
                .perform();


        //Step 5. Click the "Details" link of the order (or Enson order) you want to view.
        WebElement firstOrder = driver.findElement(By.xpath("(//*[@class='button-2 order-details-button'])[1]"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(firstOrder)
                .click()
                .build()
                .perform();


        //Step 6. Download and view the invoice by clicking on the PDF Invoice link.
        WebElement pdfInvoice = driver.findElement(By.xpath("//*[text()='PDF Invoice']"));
        Tools.Bekle(3);

        new Actions(driver)
                .moveToElement(pdfInvoice)
                .click()
                .build()
                .perform();


    }
    }
