package com.mnix.natureofchampions;

import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.CardRarity;
import com.mnix.natureofchampions.model.CardType;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
import com.mnix.natureofchampions.resolver.Mutation;
import com.mnix.natureofchampions.resolver.Query;
import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Query query(ProfileRepository profileRepository, CardRepository cardRepository) {
        return new Query(profileRepository, cardRepository);
    }

    @Bean
    public Mutation mutation(ProfileRepository profileRepository, CardRepository cardRepository) {
        return new Mutation(profileRepository, cardRepository);
    }

    @Bean
    public CommandLineRunner init(ProfileRepository profileRepository, CardRepository cardRepository) {
        return (args) -> {
            Profile profile = new Profile("MNIX");
            profileRepository.save(profile);
            initCards(cardRepository);
        };
    }

    void initCards(CardRepository cardRepository){
        cardRepository.save(new Card("Warrior", 0, CardRarity.COMMON, CardType.CHARACTER));
        cardRepository.save(new Card("Wizard", 0, CardRarity.COMMON, CardType.CHARACTER));
        cardRepository.save(new Card("Farmer", 0, CardRarity.RARE, CardType.CHARACTER));
    }

//	@Bean /* see http://www.baeldung.com/spring-git-information */
//	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//		PropertySourcesPlaceholderConfigurer gitInfo = new PropertySourcesPlaceholderConfigurer();
//		gitInfo.setLocation(new ClassPathResource("git.properties"));
//		gitInfo.setIgnoreResourceNotFound(true);
//		gitInfo.setIgnoreUnresolvablePlaceholders(true);
//		return gitInfo;
//	}

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
