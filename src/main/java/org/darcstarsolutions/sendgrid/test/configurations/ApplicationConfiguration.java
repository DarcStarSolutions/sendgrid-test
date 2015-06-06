package org.darcstarsolutions.sendgrid.test.configurations;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mharris on 6/6/15.
 */

@Configuration
@EnableConfigurationProperties(SendGridConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    private SendGridConfiguration configuration;

    @Bean
    public SendGrid sendGrid() {
        SendGrid sendGrid = new SendGrid(configuration.getUsername(), configuration.getPassword());
        return sendGrid;
    }

    @Bean
    public SendGrid.Email email() {
        SendGrid.Email email = new SendGrid.Email();
        email.addTo(configuration.getEmail().getToAddress());
        email.setSubject("SendGrid Test");
        email.setText("This is a test of the SendGrid API");
        email.setFrom(configuration.getEmail().getFromAddress());
        return email;
    }

}
