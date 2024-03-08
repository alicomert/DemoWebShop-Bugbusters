package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utlity.BaseDriver.driver;
import static Utlity.BaseDriver.wait;

public class Tools {

    public static void Bekle(int sn){

        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SuccessMessageValidation(){
        WebElement msgLabel= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }
    public static void LoginTest(){
        System.out.println("Login Test başladı");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"));
        System.out.println("Login Test bitti");
    }
}
