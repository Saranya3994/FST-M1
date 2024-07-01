import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String arg[]){
//        WebDriver driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
             WebDriver driver=new FirefoxDriver();

        driver.get("https://www.training-support.net");
        System.out.println("title of the page:"+driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();

        System.out.println("title of the page:"+driver.getTitle());
        driver.close();
    }
}
