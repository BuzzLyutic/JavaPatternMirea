package ru.mirea.Practice_24.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.Practice_24.model.University;
import ru.mirea.Practice_24.repository.UniversityRepository;

import java.util.List;
import java.util.Map;

@Service
public class UniversityServiceImpl implements UniversityService{


    private final UniversityRepository universityRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);


    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        logger.info("Entering UniversityServiceImpl constructor");
        this.universityRepository = universityRepository;
        logger.info("Exiting UniversityServiceImpl constructor");

    }

    @Transactional
    @Override
    public List<University> getAllUniversities() {
        logger.info("Entering getAllUniversities method");
        logger.info("Exiting getAllUniversities method");
        return universityRepository.findAll();

    }

    @Transactional
    @Override
    public University createUniversity(University university) {
        logger.info("Entering createUniversity method");
        logger.info("Exiting createUniversity method");
        return universityRepository.save(university);

    }

    @Transactional
    @Override
    public void deleteUniversity(Long id) {
        logger.info("Entering deleteUniversity method");
        universityRepository.deleteById(id);
        logger.info("Exiting deleteUniversity method");
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<University> findUniversitiesByCriteria(Map<String, Object> filters) {
        logger.info("Entering filterUniversitiesByCriteria method");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<University> query = cb.createQuery(University.class);
        Root<University> university = query.from(University.class);

        Predicate[] predicates = new Predicate[filters.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            if (fieldName.equals("name")) {
                predicates[i++] = cb.like(university.get("name"), "%" + fieldValue + "%");
            } else if (fieldName.equals("creationDate")) {
                predicates[i++] = cb.equal(university.get("creationDate"), fieldValue);
            }
        }

        query.select(university).where(predicates);
        logger.info("Exiting createUniversity method");
        return entityManager.createQuery(query).getResultList();
    }
}
