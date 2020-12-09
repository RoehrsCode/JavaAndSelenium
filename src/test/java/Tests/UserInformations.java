package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserInformations {
    @Test
    public void AddInformation(){
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\roehr\\IdeaProjects\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
