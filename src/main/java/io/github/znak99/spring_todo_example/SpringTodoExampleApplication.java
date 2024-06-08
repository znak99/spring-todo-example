package io.github.znak99.spring_todo_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringTodoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTodoExampleApplication.class, args);
	}

}
