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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserInformations.csv")
public class UserInformations {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roehr\\IdeaProjects\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.juliodelima.com.br/taskit/");

        driver.findElement(By.linkText("OK, I WANNA SIGN UP NOW")).click();

        WebElement SignUpBox = driver.findElement(By.id("signupbox"));

        SignUpBox.findElement(By.name("name")).sendKeys("Ana Merchury");

        SignUpBox.findElement(By.name("login")).sendKeys("anamerchury5555@gmail.com");

        SignUpBox.findElement(By.name("password")).sendKeys("ana5555@!");

        SignUpBox.findElement(By.linkText("SAVE")).click();

        WebElement me = driver.findElement(By.className("me"));
        String textMe = me.getText();
        assertEquals("Hi," , textMe);

        driver.findElement(By.linkText("Hi,")).click();
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }
    @Test
    public void AddInformation(@Param(name="types")String types, @Param(name="contacts")String contacts, @Param(name="messages")String messageEx) {
        //validation

        driver.findElement(By.xpath("//div[@id='moredata']//button[@data-target=\"addmoredata\"]")).click();

        WebElement popData = driver.findElement(By.id("addmoredata"));

        WebElement comboBox = popData.findElement(By.name("type"));
        new Select(comboBox).selectByVisibleText(types);

        popData.findElement(By.name("contact")).sendKeys(contacts);
        popData.findElement(By.linkText("SAVE")).click();

        WebElement informationAdded = driver.findElement(By.id("toast-container"));
        String mensagePop= informationAdded.getText();
        assertEquals(messageEx , mensagePop);

    }
    @Test
    public void removeInformation() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[4]/div[1]/ul/li[52]/a/i")).click();

        driver.switchTo().alert().accept();

        WebElement remove = driver.findElement(By.id("toast-container"));
        String popMessage = remove.getText();
        assertEquals("Rest in peace, dear phone!" , popMessage);

    }
    @After
    public void tearDown(){
        driver.quit();

    }
}