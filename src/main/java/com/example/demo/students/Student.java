package com.example.demo.students;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private LocalDate dob;

    @NonNull
    private Integer age;

}
