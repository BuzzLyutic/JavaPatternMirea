package ru.mirea.Practice_22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Practice_22.model.Student;
import ru.mirea.Practice_22.service.EmailService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private EmailService emailService;

    private final ru.mirea.Practice_22.service.StudentServiceImpl studentService;

    public StudentController(ru.mirea.Practice_22.service.StudentServiceImpl studentService) {
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
                emailService.sendSimpleMessage("Item was created [Shop]",
                String.format("Item (%d [%s]) was created", student.getId(), student.getLastName()));
            return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
