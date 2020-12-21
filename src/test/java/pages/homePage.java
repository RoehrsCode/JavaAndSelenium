package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends basePage {

    public homePage(WebDriver driver){
        super(driver);
    }

    public mePage clickMe(){
        driver.findElement(By.className("me")).click();

        return new mePage(driver);
    }
}
