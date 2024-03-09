package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
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
        driver.get("https://demowebshop.tricentis.com/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("technostudy@protonmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("7Nx*rp#*Rc3pS");

        WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
        loginBtn.click();
        WebElement LoginTest=driver.findElement(By.xpath("(//div//li/a)[1]")); //By.cssSelector("[value='Login']")

        wait.until(ExpectedConditions.titleIs("Demo Web Shop"));
        Assert.assertTrue(LoginTest.getText().contains("technostudy@protonmail.com"));
        System.out.println("Login Test bitti");
    }
}
