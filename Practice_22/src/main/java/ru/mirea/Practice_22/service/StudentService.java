package ru.mirea.Practice_22.service;

import ru.mirea.Practice_22.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    void deleteStudent(Long id);
    List<Student> findStudentsByCriteria(Map<String, Object> filters);
}
