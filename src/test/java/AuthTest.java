import backup.Backup;
import org.openqa.selenium.Cookie;
import salesforce.Authorization;
import salesforce.CreateObjects;
import org.testng.annotations.Test;
import webdriver.WebDriverService;

import java.util.Set;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AuthTest {

    @Test
    public void Auth() throws InterruptedException {

        CreateObjects obj = new CreateObjects();
        Backup doBackup = new Backup();
        Authorization auth = new Authorization();


//        System.out.println(obj.createAccount());
//        obj.deleteAccount();
//        obj.getAccountID();
//        obj.deleteAccount();
//        Backup.doBackup();
//        Backup.getAccount();
//        Authorization.getToken();
        Authorization.login();
//        Authorization.getValueOfCookieSb4sfOidSig();
//        System.out.println( Authorization.getValueOfCookieSb4sf());

//        Backup.getAccount();






    }
}
