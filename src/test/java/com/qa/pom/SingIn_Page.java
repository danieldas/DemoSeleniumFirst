package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class SingIn_Page extends Base {

    By cuentaLocator = By.name("userName");
    By passLocator = By.name("password");
    By submitLocator = By.name("login");
    By fontLocator = By.tagName("font");


    public SingIn_Page(WebDriver driver) {

        super(driver);
    }

    public void singinUser() throws InterruptedException {

        type("danielojalvo3",cuentaLocator);
        type("654321",passLocator);
        click(submitLocator);

    }

    public String singinMessage(){
        List<WebElement> fonts = findElements(fontLocator);
        return getText(fonts.get(7));
    }
}
