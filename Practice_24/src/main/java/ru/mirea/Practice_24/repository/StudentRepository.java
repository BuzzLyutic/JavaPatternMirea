package ru.mirea.Practice_24.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.Practice_24.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
}

/*import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Practice_17.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    EntityManager getEntityManager();
}
*/
