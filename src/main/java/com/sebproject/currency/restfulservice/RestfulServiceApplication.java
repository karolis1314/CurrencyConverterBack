package com.sebproject.currency.restfulservice;
import com.sebproject.currency.restfulservice.currencycontroller.CurrencyController;
import com.sebproject.currency.restfulservice.playground.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulServiceApplication {
	private static JobService service;
	public RestfulServiceApplication(JobService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
		service.runFetchAllToday();
	}
	
	
	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder){
		
		return restTemplateBuilder.build();
	}

}
