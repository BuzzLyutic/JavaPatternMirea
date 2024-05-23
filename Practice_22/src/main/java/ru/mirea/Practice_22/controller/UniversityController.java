package ru.mirea.Practice_22.controller;

import org.springframework.web.bind.annotation.*;
import ru.mirea.Practice_22.model.University;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final ru.mirea.Practice_22.service.UniversityServiceImpl universityService;

    public UniversityController(ru.mirea.Practice_22.service.UniversityServiceImpl universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/filter")
    public List<University> filterUniversities(@RequestParam Map<String, Object> filters) {
        return universityService.findUniversitiesByCriteria(filters);
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
    }
}
