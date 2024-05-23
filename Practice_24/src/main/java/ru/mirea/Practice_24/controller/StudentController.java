package ru.mirea.Practice_24.controller;

import org.springframework.web.bind.annotation.*;
import ru.mirea.Practice_24.model.Student;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final ru.mirea.Practice_24.service.StudentServiceImpl studentService;

    public StudentController(ru.mirea.Practice_24.service.StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/filter")
    public List<Student> filterStudents(@RequestParam Map<String, Object> filters) {
        return studentService.findStudentsByCriteria(filters);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
