package com.mnix.natureofchampions;

import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.ProfileCard;
import com.mnix.natureofchampions.model.constant.Card;
import com.mnix.natureofchampions.repository.ProfileCardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
import com.mnix.natureofchampions.resolver.Mutation;
import com.mnix.natureofchampions.resolver.Query;
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
    public Query query(ProfileRepository profileRepository, ProfileCardRepository cardRepository) {
        return new Query(profileRepository, cardRepository);
    }

    @Bean
    public Mutation mutation(ProfileRepository profileRepository) {
        return new Mutation(profileRepository);
    }

    @Bean
    public CommandLineRunner init(ProfileRepository profileRepository, ProfileCardRepository profileCardRepository) {
        return (args) -> {
            Profile profile = new Profile("MNIX");
            profileRepository.save(profile);
            profileCardRepository.save(new ProfileCard(profile, Card.WARRIOR));
        };
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
