package US_203_Logout;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_20301_Positive extends BaseDriver {

    @Test
    public void TC_20301() {
        // Anasayfada kullanıcı oturumu aç
        driver.get("https://demowebshop.tricentis.com/");
        Tools.Bekle(3);

        WebElement loginLink = driver.findElement(By.cssSelector("a.ico-login"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("technostudy@protonmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("7Nx*rp#*Rc3pS");

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginButton.click();

        // Oturum açıldığını doğrula
        WebElement accountname= driver.findElement(By.xpath("//a[@href='/customer/info']"));
        Assert.assertTrue(accountname.getText().contains("technostudy"), "Giriş yapılamadı");
        Tools.Bekle(3);

        // Çıkış yap
        WebElement logoutLink = driver.findElement(By.cssSelector("a.ico-logout"));
        logoutLink.click();

        // Çıkış yapıldığını doğrula
        WebElement loginText = driver.findElement(By.cssSelector(".header-links .ico-login"));
        Assert.assertEquals(loginText.getText(), "Log in");
        if (loginText.getText().contains("Log in")){
            System.out.println("TEST PASSED");
        }else
            System.out.println("TEST FAİLD");

    }


}

