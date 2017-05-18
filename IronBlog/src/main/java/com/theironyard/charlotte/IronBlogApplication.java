package com.theironyard.charlotte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

// include the Jsr310JpaConverter class
// with entity scanning so that when we persist
// our LocalDateTime objects, the column types
// are date-related
@EntityScan(basePackageClasses = {
	IronBlogApplication.class, Jsr310JpaConverters.class
})
@SpringBootApplication
public class IronBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(IronBlogApplication.class, args);
	}

	// allows us to register the "FooService"
	// class with the Spring container
	// while controlling how that object
	// gets created
//	@Bean
//	public FooService getService() {
//		return new FooService();
//	}
}
