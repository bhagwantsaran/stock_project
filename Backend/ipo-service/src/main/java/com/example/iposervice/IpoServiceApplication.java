package com.example.iposervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class IpoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpoServiceApplication.class, args);
	}

}
