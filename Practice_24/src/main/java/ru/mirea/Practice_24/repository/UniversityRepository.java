package ru.mirea.Practice_24.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.Practice_24.model.University;

public interface UniversityRepository extends JpaRepository<University, Long>, JpaSpecificationExecutor<University> {
}

/*import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Practice_17.model.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
    EntityManager getEntityManager();
}
*/
