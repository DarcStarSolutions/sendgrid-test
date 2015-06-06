package org.darcstarsolutions.sendgrid.test.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by mharris on 6/6/15.
 */

@ConfigurationProperties(prefix = "sendgrid")
public class SendGridConfiguration {
    private String username;
    private String password;
    private Email email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public static class Email {
        private String toAddress;
        private String fromAddress;

        public String getToAddress() {
            return toAddress;
        }

        public void setToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }
    }


}
