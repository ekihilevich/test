package backup;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import javafx.application.Application;
import salesforce.Authorization;
import salesforce.ObjForTokenResponse;
import salesforce.PostAuthObject;

import static io.restassured.RestAssured.given;
import static salesforce.ToMapConverter.toMap;

public class Backup {
    public static void doBackup() {

            String response = given()
                    .baseUri("https://bs-a-s-www.spanning.co/api")
                    .accept(ContentType.JSON).contentType(ContentType.TEXT)
                    .auth().oauth2(Authorization.getToken())
                    .cookie("sb4sf=An7ptJ11dGxHtCAsslVjGHtj8ifvFks9N3JJA7F0QZCC/mU6Lruxjr1rdT5G6fXky7PKG3OZbAGqNXcSmPV69DdYV8tT5gCqR+5G9rDnWpEh2SgAe9Qu7YsvzyZ/CL4VXhjMdyCMbVJ18e8O9yEFfMMtACgxxiygN/maKVdLfE2Bd+CHkXJ4dG0ZiH15A69mKhO1Dn+tmL0SdYpCOqZMuyMfMRgYm0TgVyQKXbqT/lLlcyc94Bu+5ChJpXiMS3jNAow2cm5LdneuOBS1OES/xSS/8xUQ47akuwxGglTS9ej+1VRbQ1/LbvA8791ojAhQLmz4c1lCvs4P8AG+qJOZLxEWo/xQxQmpkWSqZgTP/lO9nq8EMC8O0n3EFjuLzpYrvdMBwYYER7wYyp1N7/DZZ1FwohoFWwpAQKfiT+hXbmP6l5ffyCZ+95tYhq26obcZq4UqdYr8zoMK56+L6sGVbFsYP5hrfaDzclKJHB/FJvUNsoPB5YYKP027oeFYD9cPGWEe9YP30FTmV4/EierBp/I2MFvJ6663hMmzTyauOfT5+Iqg1G6455TTVU/xdV+74ekqocpxjT2mLgWhnaLC7aKgk/Gr0ahLs6+R2m37M/n4+eprFPDkhCFJ0/gOdLLw7I0WoGrd1V9DXhF25XznRFyEV6l0Nu6wTJRMFPRLq5P9XQS8FgM0Z4B9bwGm+2SVHvBXu+w9YBAubw+3yuPJ8wIPbJJiYqzp+d8I+NWuWFqPBYBys/A9ZH32PDxag0ddLbn1Idpkr4cpHEbCh1AvYJykauhcSPG9cyghQA01ljLni1kLmKpsl2pTKdNEUgUyDkmwsyGmU6M6nmUVuvSMgUHKlRKrzhvJPnOnqZiZxnyqPFqmhB6qP6AqpshxHUZPz8ZymVtvh/nfwPG29H/zRmKwyeecon1zh/KF0vtEScDeXEZkREyuWayoaKt2liAVLJAEzYBgFalxUZ9c0CWnMm0wiJAwVmG2OCU270IlEQOUqm9AD6ypMF796/LSfKiSZ5xRu4yZhnKGb8IsvtgCnNTTZnrieflE8UMxVENxdXTsfTfkPvJ0NGErgONlRmMejtLOCUmvrI2KPuiNBsGMmZLvUeDWC1dOXjzV5Joy3p7U4QGy9dHrR6kcV4Tp0OP277E4V/m69iMowvUtCZ+8fpK8aGQe5jm7Vn1mK5KTVpplR+n4Z/htcik/LolZjto/WyVK5yNHpncBtOvO0ffKphDmwCxPmXX/eNPyFANIxmiZFEI6nqEY9vDJ5+wZsC4cIxenYzNRRXD/M8sQsnC/+3rUsNqaJAlwvblLQzmDbKte6YeknYWVJ6WmrJZHcsQC4YCG9UXW+boiuQKRnDvRC6Xxwvcn0FBKfcT/2lJsHgpx/pu9EKWcf84tZOn0OoU46us4IgL1MjNSVSVFx2mTlNNVKB2n70LlFSg567GqU5CI7rNBCfJ4VEiwg4RnGbq/nlmQBeTdQ5oGASwbntJvuB29MrM26GpOdA+OTvFwBJvj64atQD0arjbphvWpNpidn9IOdG495KECZygBrMIu5Wu6H/mh6zDwF3lt+5hRmnBX7r5TXmiM+mLNnt9lfOZ7MFYjd6oLo+EkLDgAAdKnsYw0GFvztEe0FhXVVJSk+fmgwojOyRoryBvPQNYXwb8/; path=/; expires=Mon, 19 Oct 2020 14:55:34 GMT; domain=spanning.co; samesite=none; secure; httponly")

                    .when()
                    .post("/queue/backup")
                    .then()
//                    .statusCode(200)
                    .extract()
                    .response()
                    .asString();
        System.out.println(response);



    }
    public static void getAccount() {
        String response1 = given()
                .baseUri("https://bs-a-s-www.spanning.co")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .auth().oauth2(Authorization.getToken())

                .when()
                .log().cookies()
                .cookie(Authorization.getAllCookie())


                .get("/api/account")

                .then()
                .log().cookies()
//                .statusCode(200)
                .extract()
                 .response()
                .getDetailedCookies().toString();
//                .getHeader("set-cookie");
//                .getHeaders().toString();

        System.out.println(response1);

    }

}
