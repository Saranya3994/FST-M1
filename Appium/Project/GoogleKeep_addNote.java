import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class GoogleKeep_addNote {
    // Driver Declaration
    AndroidDriver driver;

    @BeforeClass
    public void setDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/");
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void addNote() {
        driver.findElement(By.id("new_note_button")).click();
        driver.findElement(By.id("editable_title")).sendKeys("Appium Activity");
        driver.findElement(By.id("edit_note_text")).sendKeys("Adding a note using Appium");
        driver.findElement(By.id("menu_reminder")).click();
        driver.findElement(By.id("reminder_time_afternoon")).click();
        driver.findElement(By.id("save")).click();
        Assert.assertEquals(driver.findElement(By.id("index_note_title")).getText(), "Appium Activity");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}