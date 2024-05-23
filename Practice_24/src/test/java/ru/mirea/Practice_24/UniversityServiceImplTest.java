package ru.mirea.Practice_24;


import jakarta.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.mirea.Practice_24.model.University;
import ru.mirea.Practice_24.repository.UniversityRepository;
import ru.mirea.Practice_24.service.UniversityServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UniversityServiceImplTest {

    @InjectMocks
    private UniversityServiceImpl universityService;

    @Mock
    private UniversityRepository universityRepository;

    @Mock
    private EntityManager entityManager;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetAllUniversities() {
        University uni1 = new University();
        uni1.setName("MIREA");
        University uni2 = new University();
        uni2.setName("MIT");

        when(universityRepository.findAll()).thenReturn(Arrays.asList(uni1, uni2));

        List<University> universities = universityService.getAllUniversities();

        assertEquals(2, universities.size());
        assertTrue(universities.contains(uni1));
        assertTrue(universities.contains(uni2));
        verify(universityRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllUniversities_EmptyList() {
        when(universityRepository.findAll()).thenReturn(Collections.emptyList());

        List<University> universities = universityService.getAllUniversities();

        assertTrue(universities.isEmpty());
        verify(universityRepository, times(1)).findAll();
    }

}
