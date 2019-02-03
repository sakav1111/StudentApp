package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
		System.out.println("========================== ");
		System.out.println("\t STUDENT APP \n");		
		System.out.println("URL : http://localhost:8080 \n ");
		System.out.println("================================");
	}

}

