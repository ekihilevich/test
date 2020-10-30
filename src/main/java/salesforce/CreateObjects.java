package salesforce;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

import java.net.URLEncoder;
import java.util.Collections;

import static io.restassured.RestAssured.*;
import static jdk.nashorn.internal.objects.NativeString.substring;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * Creating custom and general objects using REST API.
 */

public class CreateObjects {

    public String ids;
    public String createAccount() {
        AccountBody acc = AccountBody.builder()
                .name("Z.AccountAutoTestCreated")
                .build();
 String response =   given()
            .baseUri("https://na88.salesforce.com")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .auth().oauth2(Authorization.getToken())
            .body(acc)
            .post("/services/data/v20.0/sobjects/Account")
            .then()
            .statusCode(201)
            .extract()
            .response().getBody().jsonPath().get("id");
return response;


    }
    public void deleteAccount() {
        StringBuffer sb = new StringBuffer(20);
        sb.append("/services/data/v42.0/composite/sobjects?ids=").append(getAccountID()).append("&allOrNone=false");
        System.out.println(sb);
    String response = given()
                .baseUri("https://na88.salesforce.com")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .auth().oauth2(Authorization.getToken())
                .when()
            .log().all()
                .delete(sb.toString())
                .then()
            .log().all()
//                .statusCode(200)
                .extract()
                .response()
                .asString();
        System.out.println(response);




    }
    public String getAccountID() {
//        String url = URLEncoder.encode("/services/data/v20.0/query?q=SELECT+Id+from+Account");
     String accIdToDelete = given()
                .baseUri("https://na88.salesforce.com")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .auth().oauth2(Authorization.getToken())
                .when()
                .get("/services/data/v42.0/parameterizedSearch/?q=Test1&sobject=Account&Account.fields=id,name&Account.limit=3")
                .then()
                .statusCode(200)
                .extract()
//             .response()
//             .asString();
                .jsonPath()
                .getString("searchRecords.Id");
        System.out.println(accIdToDelete);
        accIdToDelete = accIdToDelete.substring(1, accIdToDelete.length() - 1).replaceAll("\\s","");
        System.out.println(accIdToDelete);

return  accIdToDelete;



    }
}
