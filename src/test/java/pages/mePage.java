package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mePage extends basePage {

    public mePage(WebDriver driver) {
        super(driver);
    }

    public mePage clickMoreDataAboutYou(){

        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clickButtonAddMoreDataAboutYou(){

        driver.findElement(By.xpath("//div[@id='moredata']//button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(driver);
    }
}
