package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {
    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        }
    @AfterMethod
   public void CloseBrowser() {
        driver.quit();
    }

}
