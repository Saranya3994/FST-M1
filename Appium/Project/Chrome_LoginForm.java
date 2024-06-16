import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Chrome_LoginForm {
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
//        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
//        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
//        driver.findElement(AppiumBy.xpath("//android.view.View[@text='To-Do List']")).click();

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Login Form']")).click();
    }
    @Test(priority = 3)
    public void Login_ValidCredential() {
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.widget.EditText")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.Button")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView")).getText().equals("Welcome Back, admin"));
    }
    @Test(priority = 4)
    public void Login_InvalidCredential() {
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.widget.EditText")).sendKeys("pass");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[5]/android.widget.Button")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView")).getText().equals("Invalid Credentials"));
    }
}
