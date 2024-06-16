import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Chrome_Popup_SignIn {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set up the driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/");
        driver = new AndroidDriver(serverURL, options);
    }
    @Test(priority = 1)
    public void chromeTest() {
        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
    }
    @Test(priority = 2)
    public void ScrollToLoginForm() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Popups']")).click();
    }
    @Test(priority = 3)
    public void SignIn_ValidCredentials() {
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")).click();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Popups\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Popups\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]")).isDisplayed());
    }
    @Test(priority = 3)
    public void SignIn_InValidCredentials() {
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Sign In']")).click();
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Popups\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Popups\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).isDisplayed());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
