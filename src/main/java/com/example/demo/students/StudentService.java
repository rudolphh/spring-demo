package com.example.demo.students;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();
    void addNew(Student student);
    void deleteStudent(Long id);
}
