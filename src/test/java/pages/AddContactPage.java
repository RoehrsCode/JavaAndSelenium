package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends basePage {

    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    public AddContactPage changeTypeContact(String types){

        WebElement comboBox = driver.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(comboBox).selectByVisibleText(types);

        return this;
    }

    public AddContactPage typeContact(String contacts){

        driver.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contacts);

        return this;
    }

    public mePage clickSave(){

        driver.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new mePage(driver);

    }

    public  mePage AddContact(String types, String contacts){

        changeTypeContact(types);
        typeContact(contacts);
        clickSave();

        return new mePage(driver);
    }
}
