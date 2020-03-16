package com.ns.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCaffeineCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCaffeineCacheDemoApplication.class, args);
	}

}
