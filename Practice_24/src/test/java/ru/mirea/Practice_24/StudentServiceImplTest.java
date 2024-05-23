package ru.mirea.Practice_24;

import jakarta.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.mirea.Practice_24.model.Student;
import ru.mirea.Practice_24.repository.StudentRepository;
import ru.mirea.Practice_24.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private EntityManager entityManager;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student();
        student1.setFirstName("Vladimir");
        student1.setMiddleName("Olegovich");
        student1.setLastName("KLimkin");
        Student student2 = new Student();
        student2.setFirstName("Ivan");
        student2.setMiddleName("Ivanovich");
        student2.setLastName("Ivanov");
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        List<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllStudents_EmptyList() {
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());

        List<Student> students = studentService.getAllStudents();

        assertTrue(students.isEmpty());
        verify(studentRepository, times(1)).findAll();
    }

}