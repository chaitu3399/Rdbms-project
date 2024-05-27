package com.chaitu.rdbms_project;

import com.chaitu.rdbms_project.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.chaitu.rdbms_project.models", basePackageClasses = UserController.class)
public class RdbmsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdbmsProjectApplication.class, args);
	}

}
