package com.noc;

import com.noc.database.Init;
import com.noc.repository.collection.CardRepository;
import com.noc.repository.collection.CardStatisticRepository;
import com.noc.repository.collection.ProfileCardRepository;
import com.noc.repository.social.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class Application {

    @Autowired
    Init init;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return (args) -> {
            init.initCards();
            init.initProfiles();
        };
    }
}
