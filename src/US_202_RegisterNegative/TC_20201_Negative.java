package US_202_RegisterNegative;

import Utlity.Tools;
import org.testng.annotations.Test;
import Utlity.BaseDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC_20201_Negative extends BaseDriver {



    @Test
    public void TC_20201() {

        driver.get("https://demowebshop.tricentis.com/register");
        Tools.Bekle(2);

        //WebElement register = driver.findElement(By.linkText("Register"));
        //register.click();
        //Kişisel Bilgiler
        WebElement cinsiyet = driver.findElement(By.xpath("//input[@id='gender-female']"));
        cinsiyet.click();

        WebElement ad = driver.findElement(By.xpath("//input[@id='FirstName']"));
        ad.sendKeys("Mary");

        WebElement soyad = driver.findElement(By.xpath("//input[@id='LastName']"));
        soyad.sendKeys("Johnson");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("techno.team12@gmail.com");

        WebElement sifre = driver.findElement(By.xpath("//input[@id='Password']"));
        sifre.sendKeys("Pass1234");

        WebElement sifreOnay = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        sifreOnay.sendKeys("Pass1234");

        // Kayıt butonuna tıkla
        WebElement kayitButon = driver.findElement(By.xpath("//input[@id='register-button']"));
        kayitButon.click();

        // Bekle ve hata mesajını kontrol et
        Tools.Bekle(1);
        WebElement hataMesaji = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/ul/li"));
        Assert.assertTrue(hataMesaji.getText().contains("The specified email already exists"), "Hata mesajı doğru görüntülenmedi.");

        // WebDriver'ı kapat
        Tools.Bekle(3);
        driver.quit();
    }

}


