import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    public void test() {
//        System.out.println("title of the page:"+driver.getTitle());
//        assertEquals(driver.getTitle(),"Training Support");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
//        driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }

}
