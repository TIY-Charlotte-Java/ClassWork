package com.theironyard.charlotte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@ComponentScan(basePackageClasses = {
	IronBlogApplication.class, Jsr310JpaConverters.class
})
@SpringBootApplication
public class IronBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(IronBlogApplication.class, args);
	}
}
