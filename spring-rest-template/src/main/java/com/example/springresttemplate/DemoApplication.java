package com.example.springresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


// Client ID:

// ANYTHING THAT SAYS "SECRET" SHOULD NORMALLY NOT EVER BE IN
// YOUR CODE

// Client Secret: 0d3290576cc61d7d4017921fb16fcc41db18d2ff
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
