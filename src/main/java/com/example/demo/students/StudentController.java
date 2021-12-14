package com.example.demo.students;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNew(@RequestBody Student student){
        try {
            studentService.addNew(student);
        }catch (IllegalStateException exc) {
            // reduces tight coupling compared to the @ExceptionHandler
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, exc.getMessage(), exc);
        }
    }

    @DeleteMapping(path = "{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Long id){
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id cannot be null");
        }

        try {
            studentService.deleteStudent(id);
        } catch (IllegalStateException exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exc.getMessage(), exc
            );
        }
    }
}
