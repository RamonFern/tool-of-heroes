package com.toolofheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(title = "API da app tools of heroes", version = "1.0.0", description = "Controle dos heroes da marvel e do ceará"),
//		servers = {
//				@Server(url = "http://localhost:8080")
//		}
//)
public class ToolOfHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolOfHeroesApplication.class, args);
	}

}
