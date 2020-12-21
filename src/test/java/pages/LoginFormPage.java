package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends basePage {

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

}
    public LoginFormPage typeName(String name){

        driver.findElement(By.id("signupbox")).findElement(By.name("name")).sendKeys(name);

        return this;
    }
    public LoginFormPage typeLogin(String login){

        driver.findElement(By.name("login")).sendKeys(login);

        return this;
    }
    public LoginFormPage typePassword(String password){

        driver.findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public homePage clickSave(){

        driver.findElement(By.linkText("SAVE")).click();

        return new homePage(driver);
    }

    public homePage doSignUp(String name, String login, String password){

        typeName(name);
        typeLogin(login);
        typePassword(password);
        clickSave();

        return new homePage(driver);
    }

}
