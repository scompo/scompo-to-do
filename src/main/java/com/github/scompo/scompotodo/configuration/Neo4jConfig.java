package com.github.scompo.scompotodo.configuration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.github.scompo.scompotodo.repository")
public class Neo4jConfig extends Neo4jConfiguration {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Neo4jConfig.class);
	
	public Neo4jConfig(){
		
		setBasePackage("com.github.scompo.scompotodo.domain");
	}

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {

		logger.info("Using embedded database");
		return new GraphDatabaseFactory()
				.newEmbeddedDatabase("scompo-to-do.db");
	}
}
