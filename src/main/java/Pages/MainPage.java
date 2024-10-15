package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {
    @Step("Hesabım bilgisi alınır.")
    public String getAccountName() {
        String value = driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        return value;
    }
}
