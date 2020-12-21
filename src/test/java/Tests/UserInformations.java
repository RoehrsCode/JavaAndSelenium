package Tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import support.WebMachine;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)

@DataLoader(filePaths = "AddInformation.csv")

public class UserInformations {

    private WebDriver driver;

    @Before

    public void setUp(){
        driver = WebMachine.createChrome();

    }
    @Test
    public void AddInformation(

            @Param(name="types")String types,
            @Param(name="contacts")String contacts,
            @Param(name="messages")String messageEx,
            @Param(name="name")String name,
            @Param(name="login")String login,
            @Param(name="password")String password) {

        String textToast = new LoginPage(driver)
                .clickSignUp()
                .doSignUp(name ,login , password)
                .clickMe()
                .clickMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou()
                .AddContact(types, contacts)
                .getTextToast();
                assertEquals(messageEx , textToast);

    }
    @Test
    public void removeInformation() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[4]/div[1]/ul/li[52]/a/i")).click();

        driver.switchTo().alert().accept();

        WebElement remove = driver.findElement(By.id("toast-container"));
        String popMessage = remove.getText();
        assertEquals("Rest in peace, dear phone!" , popMessage);

        WebDriverWait waiting = new WebDriverWait(driver, 10);

        waiting.until(ExpectedConditions.stalenessOf(remove));

    }
    @After
    public void tearDown(){

        driver.quit();

    }
}