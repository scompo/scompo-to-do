package com.github.scompo.scompotodo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.github.scompo.scompoToDo.domain")
public class Application extends Neo4jConfiguration {
	
	public Application(){

		setBasePackage("com.github.scompo.scompoToDo");
		System.err.println("set base packages");
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {

		System.err.println("creating graph service");
		return new GraphDatabaseFactory()
				.newEmbeddedDatabase("scompo-to-do.db");
	}

}
