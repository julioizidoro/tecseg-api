package br.com.tecsegapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TecsegApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecsegApiApplication.class, args);
	}

}
