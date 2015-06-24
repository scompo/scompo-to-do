package com.github.scompo.scompotodo.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
public class Neo4jConfig extends Neo4jConfiguration {

	{
		setBasePackage("com.github.scompo.scompoToDo.domain");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {

		return new GraphDatabaseFactory()
				.newEmbeddedDatabase("scompo-to-do.db");
	}
}
