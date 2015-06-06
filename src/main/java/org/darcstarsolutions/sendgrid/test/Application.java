package org.darcstarsolutions.sendgrid.test;

import com.sendgrid.SendGrid;
import org.darcstarsolutions.sendgrid.test.configurations.SendGridConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by mharris on 6/6/15.
 */

@SpringBootApplication
@EnableConfigurationProperties
public class Application implements CommandLineRunner {

    @Autowired
    private SendGrid.Email email;

    @Autowired
    private SendGrid sendGrid;

    @Autowired
    private SendGridConfiguration configuration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Configuration--Sent to: " + configuration.getEmail().getToAddress());
        System.out.println("Configuration--Sent from: " + configuration.getEmail().getFromAddress());
        System.out.println("Email--Sent to: " + email.getTos()[0]);
        System.out.println("Email--Sent from: " + email.getFrom());
        SendGrid.Response response = sendGrid.send(email);
        System.out.println("Email sent with response: " + response.getMessage());
    }
}
