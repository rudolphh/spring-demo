package com.example.demo.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.MAY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student imogen = new Student(
                    "imogen",
                    "imi@rudyah.com",
                    LocalDate.of(2018, AUGUST, 7));

            Student honey = new Student(
                    "samantha",
                    "sammi@rudyah.com",
                    LocalDate.of(1984, MAY, 10));

            repository.saveAll(List.of(imogen, honey));
        };
    }
}
