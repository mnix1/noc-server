package com.mnix.natureofchampions;

import com.mnix.natureofchampions.database.Init;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.CardStatisticRepository;
import com.mnix.natureofchampions.repository.ProfileCardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
import com.mnix.natureofchampions.resolver.Mutation;
import com.mnix.natureofchampions.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Query query(ProfileRepository profileRepository, ProfileCardRepository profileCardRepository, CardRepository cardRepository, CardStatisticRepository cardStatisticRepository) {
        return new Query(profileRepository, profileCardRepository, cardRepository, cardStatisticRepository);
    }

    @Bean
    public Mutation mutation(ProfileRepository profileRepository) {
        return new Mutation(profileRepository);
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
