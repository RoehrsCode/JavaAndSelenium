package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserInformations {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roehr\\IdeaProjects\\Drivers\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.juliodelima.com.br/taskit/");
    }
    @Test
    public void AddInformation() {

        driver.findElement(By.linkText("OK, I WANNA SIGN UP NOW")).click();

        WebElement SignUpBox = driver.findElement(By.id("signupbox"));

        SignUpBox.findElement(By.name("name")).sendKeys("Ana Merchury");

        SignUpBox.findElement(By.name("login")).sendKeys("anamerchury5555@gmail.com");

        SignUpBox.findElement(By.name("password")).sendKeys("ana5555@!");

        SignUpBox.findElement(By.linkText("SAVE")).click();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}