package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ✅ GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // ✅ POST add student 
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }
    
 // ✅ UPDATE student by ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.update(id, student);
    }

 // ✅ DELETE student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "Student deleted successfully";
    }


}
