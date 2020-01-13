package com.qa.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SingIn_Test {
    private WebDriver driver;
    private String url;
    SingIn_Page singinPage;

    @Before
    public void setUp(){
        url = "http://newtours.demoaut.com/mercurywelcome.php";
        singinPage = new SingIn_Page(driver);
        driver = singinPage.chromeDriverConnection();
        singinPage.visit(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSinginPOM() throws InterruptedException {
        singinPage.singinUser();
        assertEquals("Flight Details",singinPage.singinMessage());
    }
}
