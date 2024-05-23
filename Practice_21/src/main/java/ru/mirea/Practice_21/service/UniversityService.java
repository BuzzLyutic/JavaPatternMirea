package ru.mirea.Practice_21.service;

import ru.mirea.Practice_21.model.University;

import java.util.List;
import java.util.Map;

public interface UniversityService {
    List<University> getAllUniversities();
    University createUniversity(University university);
    void deleteUniversity(Long id);
    List<University> findUniversitiesByCriteria(Map<String, Object> filters);

}
