package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebMachine {

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roehr\\IdeaProjects\\Drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.juliodelima.com.br/taskit/");

        return driver;
    }

}
