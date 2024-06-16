import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Googletasks {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".GoogleTasksSplashScreenActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void addTask1() {
        driver.findElement(By.id("tasks_fab")).click();
        driver.findElement(By.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(By.id("add_task_done")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Tasks\"]"));

    }
    @Test
    public void addTask2() {
        driver.findElement(By.id("tasks_fab")).click();
        driver.findElement(By.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(By.id("add_task_done")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id=\"com.google.android.apps.tasks:id/task_name\" and @text=\"Complete Activity with Google Keep\"]"));
    }
    @Test
    public void addTask3() {
        driver.findElement(By.id("tasks_fab")).click();
        driver.findElement(By.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(By.id("add_task_done")).click();
        Assert.assertEquals(driver.findElement(By.id("task_name")).getText(), "Complete the second Activity Google Keep");
    }
}
