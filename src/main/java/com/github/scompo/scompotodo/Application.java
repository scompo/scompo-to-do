package com.github.scompo.scompotodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application{

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
