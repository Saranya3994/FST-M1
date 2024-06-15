import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }
    @Test
    public void testcase1() {
        System.out.println("title of the page:"+driver.getTitle());
        assertEquals(driver.getTitle(),"Target Practice");
    }
    @AfterTest
    public void closedriver() {
        driver.close();
    }
    @Test
    public void testcase2() {
    WebElement black=driver.findElement(By.xpath("//button[contains(text(),'Black')]"));
    assertTrue(black.isDisplayed());
    }
    @Test(enabled = false)
    public void testcase3() {

    }
    @Test
    public void testcase4() {
            throw new SkipException("Skipping - This is not ready for testing ");
    }
}
