package com.bridgelabz.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class MsNoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNoteServiceApplication.class, args);
	}

}
