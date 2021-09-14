package com.sebproject.currency.restfulservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder){
		
		return restTemplateBuilder.build();
	}

}
