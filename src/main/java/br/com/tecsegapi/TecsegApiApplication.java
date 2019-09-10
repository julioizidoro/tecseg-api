package br.com.tecsegapi;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TecsegApiApplication {
	
	@PostConstruct
    public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TecsegApiApplication.class, args);
	}

}
