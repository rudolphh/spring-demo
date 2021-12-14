package com.example.demo.students;

import com.example.demo.error.DuplicateEmailException;
import com.example.demo.error.StudentNotFoundException;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
//@Service
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
            throw new DuplicateEmailException("email already exists");
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id){
        boolean exist = studentRepository.existsById(id);
        if(!exist) {
            throw new StudentNotFoundException("Student with id: " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id + " does not exist"));

        String name = student.getName();
        String email = student.getEmail();
        LocalDate dob = student.getDob();

        if(name != null && !name.isEmpty() && !Objects.equals(existingStudent.getName(), name)){
            existingStudent.setName(name);
        }

        if(email != null && !email.isEmpty() && !Objects.equals(existingStudent.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new DuplicateEmailException("email already exists");
            }
            existingStudent.setEmail(email);
        }

        if(dob != null && !Objects.equals(existingStudent.getDob(), dob)){
            existingStudent.setDob(dob);
        }
    }
}
