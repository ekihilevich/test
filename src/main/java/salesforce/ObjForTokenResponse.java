package salesforce;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object for saving response from authorization request.
 */

public class ObjForTokenResponse {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "instance_url")
    private String instanceUrl;
    private String id;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "issued_at")
    private String issuedAt;
    private String signature;


    public ObjForTokenResponse(String accessToken, String instanceUrl, String id, String tokenType, String issuedAt, String signature) {
        this.accessToken = accessToken;
        this.instanceUrl = instanceUrl;
        this.id = id;
        this.tokenType = tokenType;
        this.issuedAt = issuedAt;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "ObjForTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", instanceUrl='" + instanceUrl + '\'' +
                ", id='" + id + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", issuedAt='" + issuedAt + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public ObjForTokenResponse() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
