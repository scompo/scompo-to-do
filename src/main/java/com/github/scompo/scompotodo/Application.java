package com.github.scompo.scompotodo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application extends Neo4jConfiguration {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	{
		setBasePackage("com.github.scompo.scompoToDo.domain");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {

		return new GraphDatabaseFactory()
				.newEmbeddedDatabase("scompo-to-do.db");
	}
}
