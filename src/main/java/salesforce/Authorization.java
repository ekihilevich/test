package salesforce;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import webdriver.WebDriverService;

import java.util.Set;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static salesforce.ToMapConverter.toMap;
import static io.restassured.RestAssured.given;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



/**
 * Is used for authorise and getting authorization token
 */

public class Authorization {

    private static String token;

    public static String getToken() {
        PostAuthObject toSend = PostAuthObject.builder()
                .userName("spanadmin@spanningtest.com")
                .password("zdf52%n@XVv0")
                .grantType("password")
                .clientId("3MVG9A2kN3Bn17hsDMegIFEyKo2mJKuleQg_nnaBWmBW8okTk2tpwHOqZ1m_9NAfRZttQGa91dO94edu25wgI")
                .clientSecret("3870827296836751790")
                .build();
        ObjForTokenResponse response = given()
                .baseUri("https://login.salesforce.com")
                .params(toMap(toSend))
                .when()
                .log().all()
                .post("/services/oauth2/token")
                .then()
                .log().all()
//                .statusCode(200)
                .extract()

                .as(ObjForTokenResponse.class);
        token = response.getAccessToken();
        System.out.println(response);
        return token;
    }

    public static void login() throws InterruptedException {
        open("https://login.salesforce.com");
        $("[id='username']").setValue("spanadmin@spanningtest.com");
        $("[id='password']").sendKeys("zdf52%n@XVv0");
        $("[id='Login']").click();
        $("[title='SpanningBackup Tab']").should(exist).click();
        Selenide.Wait();
        Thread.sleep(10000);


        getWebDriver().manage().getCookieNamed("sb4sf").getValue();


    }

    public static String getValueOfCookieSb4sf() {
        return getWebDriver().manage().getCookieNamed("sb4sf").getValue();
    }
    public static String getValueOfCookieSb4sfSig() {
        return getWebDriver().manage().getCookieNamed("sb4sf.sig").getValue();
    }
    public static String getValueOfCookieSb4sfOid() {
        return getWebDriver().manage().getCookieNamed("sb4sf_oid").getValue();
    }
    public static String getValueOfCookieSb4sfOidSig() {
        return getWebDriver().manage().getCookieNamed("sb4sf_oid.sig").getValue();
    }
    public static String getAllCookie() {
        return getValueOfCookieSb4sf()+getValueOfCookieSb4sfOid()+getValueOfCookieSb4sfSig()+getValueOfCookieSb4sfOidSig();
    }
}
