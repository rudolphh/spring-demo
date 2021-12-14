package com.example.demo.students;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    @Override
    public void addNew(Student student){

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email already exists");
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id){
        boolean exist = studentRepository.existsById(id);
        if(!exist) {
            throw new IllegalStateException("Student with id: " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}
