package ru.mirea.Practice_23.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.Practice_23.LoggingAspect;
import ru.mirea.Practice_23.model.Student;
import ru.mirea.Practice_23.repository.StudentRepository;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        logger.debug("Entering StudentServiceImpl constructor");
        logger.info("Informational log");
        logger.warn("Warning log");
        logger.error("Error log");
        this.studentRepository = studentRepository;
        logger.debug("Exiting StudentServiceImpl constructor");
    }

    @Transactional
    @Override
    public List<Student> getAllStudents() {
        logger.debug("Entering getAllStudents method");
        logger.debug("Exiting getAllStudents method");
        return studentRepository.findAll();
    }

    @Transactional
    @Override
    public Student createStudent(Student student) {
        logger.debug("Entering createStudent method");
        logger.debug("Exiting createStudent method");
        return studentRepository.save(student);

    }

    @Transactional
    @Override
    public void deleteStudent(Long id) {
        logger.debug("Entering deleteStudent method");
        studentRepository.deleteById(id);
        logger.debug("Exiting deleteStudent method");
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Student> findStudentsByCriteria(Map<String, Object> filters) {
        logger.debug("Entering findStudentsByCriteria method");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> student = query.from(Student.class);

        Predicate[] predicates = new Predicate[filters.size()];
        int i = 0;
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            if (fieldName.equals("id")) {
                predicates[i++] = cb.equal(student.get("id"), fieldValue);
            } else if (fieldName.equals("firstName") || fieldName.equals("middleName") || fieldName.equals("lastName")) {
                predicates[i++] = cb.like(student.get(fieldName), "%" + fieldValue + "%");
            } else if (fieldName.equals("universityId")) {
                predicates[i++] = cb.equal(student.get("university").get("id"), fieldValue);
            }
        }

        query.select(student).where(predicates);
        logger.debug("Exiting findStudentsByCriteria method");
        return entityManager.createQuery(query).getResultList();
    }
}
