package US_204_Login;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_20401_Positive extends BaseDriver {
@Test
    public void Tc204Login(){

    driver.get("https://demowebshop.tricentis.com/login");
    Tools.Bekle(2);

    WebElement email=driver.findElement(By.id("Email"));
    email.sendKeys("technostudy@protonmail.com");

    WebElement password=driver.findElement(By.id("Password"));
    password.sendKeys("7Nx*rp#*Rc3pS");

    WebElement loginBtn=driver.findElement(By.xpath("(//input[@type='submit'])[2]")); //By.cssSelector("[value='Login']")
    loginBtn.click();
    WebElement LoginTest=driver.findElement(By.xpath("(//div//li/a)[1]")); //By.cssSelector("[value='Login']")

    WebElement accountname= driver.findElement(By.xpath("//a[@href=\"/customer/info\"]"));

   Assert.assertTrue(accountname.getText().contains("technostudy"), "Giriş yapılamadı");

   if (accountname.getText().contains("technostudy")){
       System.out.println("TEST PASSED");
   }else
       System.out.println("TEST FAİLD");



}

}
