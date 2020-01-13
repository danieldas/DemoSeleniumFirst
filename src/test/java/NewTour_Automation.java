import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class NewTour_Automation {
    private WebDriver driver;

    By registerLinkLocator = By.linkText("REGISTER");
    By registerImagePageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerButtonLocator = By.name("register");
    By fontLocator = By.tagName("font");



    By singonLocator = By.linkText("SIGN-ON");
    By singonImagePageLocator = By.xpath("//img[@src='/images/masts/mast_signon.gif']");
    By cuentaLocator = By.name("userName");
    By passLocator = By.name("password");
    By submitLocator = By.name("login");
    By signoff=By.xpath("//a[text()='SIGN-OFF']");
    By registration=By.xpath("//a[contains(text(),'registration')]");



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/");
    }

    @Test
    public void RegisterUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(registerImagePageLocator).isDisplayed()){
            driver.findElement(userNameLocator).sendKeys("danielojalvo");
            driver.findElement(passwordLocator).sendKeys("654321");
            driver.findElement(confirmPasswordLocator).sendKeys("654321");

            driver.findElement(registerButtonLocator).click();
        }
        else {
            System.out.println("Page Register not found");
        }

        List<WebElement> fonts = driver.findElements(fontLocator);

        assertEquals("Note: Your user name is danielojalvo.",fonts.get(5).getText());
    }

    //Verificar con passowrd valido
    @Test
    public  void credencialesCorrectas() throws InterruptedException {
        driver.findElement(singonLocator).click();
        Thread.sleep(3000);

        if(driver.findElement(singonImagePageLocator).isDisplayed()){
            driver.findElement(cuentaLocator).sendKeys("danielojalvo");
            driver.findElement(passLocator).sendKeys("654321");
            driver.findElement(submitLocator).click();
        }
        else{
            System.out.print("Page Not Found");
        }
        assertTrue(driver.findElement(signoff).isDisplayed());
    }

    //Verificar con passowrd invalido
    @Test
    public  void credencialesIncorrectas() throws InterruptedException {
        driver.findElement(singonLocator).click();
        Thread.sleep(2000);

        if(driver.findElement(singonImagePageLocator).isDisplayed()){
            driver.findElement(cuentaLocator).sendKeys("danielojalvo");
            driver.findElement(passLocator).sendKeys("passwordincorrecto");
            driver.findElement(submitLocator).click();
        }
        else{
            System.out.print("Page Not Found");
        }

        assertTrue(driver.findElement(registration).isDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
