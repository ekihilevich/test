package salesforce;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object for sending as body in auth request.
 */

public class PostAuthObject {
    @JsonProperty(value = "username")
    private String userName;
    private String password;
    @JsonProperty(value = "grant_type")
    private String grantType;
    @JsonProperty(value = "client_id")
    private String clientId;

    @JsonProperty(value = "client_secret")
    private String clientSecret;

    private PostAuthObject() {

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public static Builder builder() {
        return new PostAuthObject().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder userName(String userName) {
            PostAuthObject.this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            PostAuthObject.this.password = password;
            return this;
        }

        public Builder grantType(String grantType) {
            PostAuthObject.this.grantType = grantType;
            return this;
        }

        public Builder clientId(String clientId) {
            PostAuthObject.this.clientId = clientId;
            return this;
        }


        public Builder clientSecret(String clientSecret) {
            PostAuthObject.this.clientSecret = clientSecret;
            return this;
        }

        public PostAuthObject build() {
            return PostAuthObject.this;
        }
    }
}
