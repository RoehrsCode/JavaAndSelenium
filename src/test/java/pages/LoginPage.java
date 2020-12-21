package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends basePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage clickSignUp(){
        driver.findElement(By.linkText("OK, I WANNA SIGN UP NOW")).click();

        return new LoginFormPage(driver);
    }
}
