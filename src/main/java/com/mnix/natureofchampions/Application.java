package com.mnix.natureofchampions;

import com.mnix.natureofchampions.database.Init;
import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.CardStatistic;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.ProfileCard;
import com.mnix.natureofchampions.model.constant.card.Rarity;
import com.mnix.natureofchampions.model.constant.card.Statistic;
import com.mnix.natureofchampions.model.constant.card.Type;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
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





	@Bean /* see http://www.baeldung.com/spring-git-information */
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer gitInfo = new PropertySourcesPlaceholderConfigurer();
		gitInfo.setLocation(new ClassPathResource("git.properties"));
		gitInfo.setIgnoreResourceNotFound(true);
		gitInfo.setIgnoreUnresolvablePlaceholders(true);
		return gitInfo;
	}

//	@Bean
//	GraphQLSchema schema() {
//		return GraphQLSchema.newSchema()
//				.query(GraphQLObjectType.newObject()
//						.name("query")
//						.field(field -> field
//								.name("test")
//								.type(Scalars.GraphQLString)
//								.dataFetcher(environment -> "response")
//						)
//						.build())
//				.build();
//	}

}
