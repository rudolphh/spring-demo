package com.example.demo;

import com.example.demo.students.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<Student> getStudents(){
		return List.of(
			new Student(1L, "imogen", "imi@rudyah.com", LocalDate.of(2022, 8, 3), 3)
		);
	}

}