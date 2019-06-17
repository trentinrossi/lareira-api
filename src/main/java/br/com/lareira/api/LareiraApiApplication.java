package br.com.lareira.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.lareira.api.config.property.LareiraApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(LareiraApiProperty.class)
public class LareiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LareiraApiApplication.class, args);
	}

}
