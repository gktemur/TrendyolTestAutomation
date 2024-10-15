package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
    @Step("Mail adresi doldurulur")
    public LoginPage fillMail(String text) {
        WebElement element =driver.findElement(By.id("login-email"));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Step("Şifre alanı doldurulur")
    public LoginPage fillPassword(String text) {
        WebElement element = driver.findElement(By.name("login-password"));
        element.clear();
        element.sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Login butonu tıklanır")
    public LoginPage clickLoginButton() {
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        return this;
    }

    @Step("Hata mesajı alınır.")
    public String getErrorMessage(){
        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        screenshot();
      return value;

    }
}
