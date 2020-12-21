package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends basePage {

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage typeLogin(String login) {

        driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage typePassword(String password) {

        driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public homePage clickSave() {

        driver.findElement(By.linkText("SIGN IN")).click();

        return new homePage(driver);
    }

    public homePage doSignIn(String login, String password) {

        typeLogin(login);
        typePassword(password);
        clickSave();

        return new homePage(driver);
    }
}