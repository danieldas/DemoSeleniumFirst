package com.qa.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Register_Test {
    private WebDriver driver;
    private String url;
    Register_Page registerPage;

    @Before
    public void setUp(){
        url = "http://newtours.demoaut.com/mercurywelcome.php";
        registerPage = new Register_Page(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testRegisterPOM() throws InterruptedException {
        registerPage.registerUser();
        assertEquals("Note: Your user name is danielojalvo3.",registerPage.registerMessage());
    }
}
