package com.github.scompo.scompotodo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.github.scompo.scompoToDo.repository")
public class Neo4jConfig extends Neo4jConfiguration {
	
	public Neo4jConfig(){
		
		setBasePackage("com.github.scompo.scompoToDo.domain");
		System.err.println("set base packages");
	}

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {

		System.err.println("creating graph service");
		return new GraphDatabaseFactory()
				.newEmbeddedDatabase("scompo-to-do.db");
	}
}
