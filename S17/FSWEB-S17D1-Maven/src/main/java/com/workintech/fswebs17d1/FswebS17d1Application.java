package com.workintech.fswebs17d1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FswebS17d1Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(FswebS17d1Application.class, args);
		System.out.println("Pelin");


	}
	@Value("${course.name}")
	private String courseName;

	@Value("${project.developer.fullname}")
	private String developerName;



	@Override
	public void run(String... args) {
		System.out.println("Course: " + courseName);
		System.out.println("Developer: " + developerName);
	}
}



