import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    LoginPage login = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
        public void LoginSuccessful() throws InterruptedException {
            login.fillMail(mail)
                    .fillPassword(password)
                    .clickLoginButton();
            sleep(3000);
            String value = mainPage.getAccountName();
            assertEquals("Hesabım",value);
    }

    @Test
    public void LoginUnSuccessful() throws InterruptedException {

        login.fillMail(mail)
                .fillPassword("abc")
                .clickLoginButton();
        sleep(3000);
        String value = login.getErrorMessage();
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.",value);
    }


    @Test
    public void RequiredControl() throws InterruptedException {


        login.clickLoginButton();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        login.fillMail(mail)
                .clickLoginButton();
        String value2 = login.getErrorMessage();
        Assert.assertEquals("Lütfen şifrenizi giriniz.", value2);
        login.fillPassword(password)
                .clickLoginButton();
        sleep(3000);
        String value3 = mainPage.getAccountName();
        assertEquals("Hesabım", value3);
    }

    @Test
    public void MinMaxCharacterControl() throws InterruptedException {

        login.fillMail("a")
                .fillPassword("abc")
                .clickLoginButton();
        sleep(3000);
        String value = login.getErrorMessage();
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        login.fillMail(mail)
                        .clickLoginButton();


        sleep(3000);
        String value2 = login.getErrorMessage();
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value2);
        login.fillPassword(password)
                        .clickLoginButton();
        sleep(3000);
        String value3 = mainPage.getAccountName();
        Assert.assertEquals("Hesabım", value3);

    }
}
