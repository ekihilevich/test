package salesforce;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object is creating for sending as account body in REST API request.
 */

public class AccountBody {
    @JsonProperty(value = "Name")
    private String name;

    public static AccountBody.Builder builder() {
        return new AccountBody().new Builder();
    }

    public String getName() {
        return name;
    }

    public AccountBody() {
    }
    public class Builder {

        private Builder() {
        }

        public Builder name(String name) {
            AccountBody.this.name = name;
            return this;
        }
        public AccountBody build() {
            return AccountBody.this;
        }
    }
}