package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

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
    public void AddInformation() {
        //validation

        driver.findElement(By.xpath("//div[@id='moredata']//button[@data-target=\"addmoredata\"]")).click();

        WebElement popData = driver.findElement(By.id("addmoredata"));

        WebElement comboBox = popData.findElement(By.name("type"));
        new Select(comboBox).selectByVisibleText("Phone");

        popData.findElement(By.name("contact")).sendKeys("999969999999999");
        popData.findElement(By.linkText("SAVE")).click();

        WebElement informationAdded = driver.findElement(By.id("toast-container"));
        String mensagePop= informationAdded.getText();
        assertEquals("Your contact has been added!" , mensagePop);

    }
    @Test
    public void removeInformation(){
        driver.findElement(By.xpath("//span[text()=\"999969999999999\"]/follow-sibling::a")).click();

        driver.switchTo().alert().accept();

        WebElement removePhone = driver.findElement(By.id("toast-container"));
        String mensagePop = removePhone.getText();
        assertEquals("Rest in peace, dear phone!" , mensagePop);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.stalenessOf(mensagePop));

        driver.findElement(By.linkText("Logout")).click();
    }
    @After
    public void tearDown(){
        //driver.quit();

    }
}