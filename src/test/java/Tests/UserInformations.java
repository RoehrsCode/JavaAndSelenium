package Tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
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
            @Param(name="login")String login,
            @Param(name="password")String password) {

        String textToast = new LoginPage(driver)

                .clickSignIn()
                .doSignIn(login, password)
                .clickMe()
                .clickMoreDataAboutYou()
                .clickButtonAddMoreDataAboutYou()
                .AddContact(types, contacts)
                .getTextToast();
                assertEquals(messageEx , textToast);

    }
    @DataLoader(filePaths = "RemoveInformation.csv")
    @Test
    public void RemoveInformation(

            @Param(name="login")String login,
            @Param(name="password")String password,
            @Param(name="messages")String messages){

        String textToastRemove = new LoginPage(driver)
                .clickSignIn()
                .doSignIn(login, password)
                .clickMe()
                .clickMoreDataAboutYou()
                .removeContact()
                .getTextToastRemove();
                assertEquals(messages , textToastRemove);
    }
    @After
    public void tearDown(){

        driver.quit();

    }
}