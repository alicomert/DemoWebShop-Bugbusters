package US_205_Login_Negative;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_20501_Negative extends BaseDriver {

    @Test(priority = 1)

    public void Tc205NegativeLoginEmptyBoth() {

        driver.get("https://demowebshop.tricentis.com/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("");

        WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
        loginBtn.click();
        WebElement LoginTest=driver.findElement(By.xpath("(//div//li/a)[1]")); //By.cssSelector("[value='Login']")


        WebElement error=driver.findElement(By.xpath("//div[@class=\"message-error\"]"));////span[text()='Login was unsuccessful. Please correct the errors and try again.']
        Assert.assertTrue(error.isDisplayed());
       if (error.isEnabled()){
           System.out.println("TEST PASSED");

       }else System.out.println("TEST FAİL");



    }

    @Test(priority = 2)
    public void Tc205NegativeLoginEmptyPass(){

        driver.get("https://demowebshop.tricentis.com/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("technostudy@protonmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("");

        WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        WebElement cridantial=driver.findElement(By.xpath("//li[text()='The credentials provided are incorrect']"));
        Assert.assertTrue(cridantial.isDisplayed());

        if (cridantial.isDisplayed()){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAİL");


    }
    @Test(priority = 3)

    public void  Tc205NegativeLoginEmptyEmailValidPass(){


        driver.get("https://demowebshop.tricentis.com/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("7Nx*rp#*Rc3pS");

        WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        WebElement NocustomerFound=driver.findElement(By.xpath("//li[text()='No customer account found']"));

        Assert.assertTrue(NocustomerFound.isDisplayed());
        if (NocustomerFound.isDisplayed()){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAİL");

    }
    @Test(priority = 4)

    public void Tc205NegativeLoginInvalidEmailValidPass(){

        driver.get("https://demowebshop.tricentis.com/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("asdasd@gmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("123asd");

        WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        WebElement cridentialError=driver.findElement(By.xpath("//li[text()='The credentials provided are incorrect']"));

        Assert.assertTrue(cridentialError.isDisplayed());

        if (cridentialError.isDisplayed()){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAİL");


    }


}
