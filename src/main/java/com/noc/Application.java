package com.noc;

import com.noc.database.Init;
import com.noc.repository.CardRepository;
import com.noc.repository.CardStatisticRepository;
import com.noc.repository.ProfileCardRepository;
import com.noc.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(ProfileRepository profileRepository, ProfileCardRepository profileCardRepository, CardRepository cardRepository, CardStatisticRepository cardStatisticRepository) {
        return (args) -> {
            Init init = new Init(profileRepository, profileCardRepository, cardRepository, cardStatisticRepository);
            init.initCards();
            init.initProfiles();
        };
    }
}
