package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {

    protected WebDriver driver;

    public basePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTextToast(){
        return driver.findElement(By.id("toast-container")).getText();
    }

    public String getTextToastRemove(){ return driver.findElement(By.id("toast-container")).getText(); }
}
