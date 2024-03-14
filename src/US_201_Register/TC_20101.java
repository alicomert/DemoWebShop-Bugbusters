package US_201_Register;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC_20101 extends BaseDriver {


    @Test
    public void TC_20101() {
        driver.get("https://demowebshop.tricentis.com/register");
        Tools.Bekle(3);

        // Kişisel Bilgiler
        WebElement cinsiyet = driver.findElement(By.xpath("//input[@id='gender-female']"));
        cinsiyet.click();

        WebElement ad = driver.findElement(By.xpath("//input[@id='FirstName']"));
        ad.sendKeys("Team");

        WebElement soyad = driver.findElement(By.xpath("//input[@id='LastName']"));
        soyad.sendKeys("Oniki");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("techno.team12@gmail.com");

        WebElement sifre = driver.findElement(By.xpath("//input[@id='Password']"));
        sifre.sendKeys("Pass1234");

        WebElement sifreOnay = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        sifreOnay.sendKeys("Pass1234");

        // Kayıt butonuna tıkla
        WebElement kayitOlButonu = driver.findElement(By.xpath("//input[@id='register-button']"));
        kayitOlButonu.click();

        // WebDriver'ı kapat
        Tools.Bekle(2);
        driver.quit();
    }






}
