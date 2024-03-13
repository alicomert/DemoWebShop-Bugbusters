package US_207_SurveyVoting;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_20701_Positive extends BaseDriver {
    @Test(priority = 1)
    public void Test1() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement excellentVote = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        excellentVote.click();
        WebElement vote = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        vote.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Only registered users can vote.']")));
        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Only registered users can vote.']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "\"Error: 'Only registered users can vote.' message is not visible.");
        String errorText = errorMessage.getText();
        System.out.println("errorText = " + errorText);

    }

    @Test(priority = 2)
    public void Test2() {
        Tools.LoginTest();
        WebElement excellentVote = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));

        if (excellentVote.isEnabled()) {
            excellentVote.click();
            // Assert.assertTrue(excellentVote.getText().contains("Excellent "));

        } else
            System.out.println("Test Fail");
        //excellentVote.click();
        //WebElement vote = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        //vote.click();

    }

    @Test(priority = 3)
    public void test3() {
        Tools.LoginTest();

        WebElement pollResultsElement = driver.findElement(By.className("poll-results"));
        String pollResults = pollResultsElement.getText();
        Assert.assertTrue(pollResultsElement.isDisplayed(), "Error: 'poll-total-votes' message is not visible.");
        System.out.println("poll-total-votes : \n " + pollResults);

    }
}




