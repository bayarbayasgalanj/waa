package chat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableScheduling
public class SpringBootReactiveApplication {
	@Autowired
	ReactiveMongoTemplate reactiveMongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApplication.class, args);
	}

	@PostConstruct
	public void init() {
		reactiveMongoTemplate.dropCollection("chatMessage").then(reactiveMongoTemplate.createCollection("chatMessage",
				CollectionOptions.empty().capped().size(2048).maxDocuments(10000))).block();
	}


}
