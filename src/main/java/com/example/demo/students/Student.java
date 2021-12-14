package com.example.demo.students;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter @ToString
@Entity @Table(name="students")
public class Student {

    @Id
    @SequenceGenerator(
            name="student_seq",
            sequenceName = "student",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private LocalDate dob;

    @Transient
    private Integer age;

    public Student(Long id, @NonNull String name, @NonNull String email, @NonNull LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
