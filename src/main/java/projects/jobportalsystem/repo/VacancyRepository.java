package projects.jobportalsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.jobportalsystem.entity.Vacancy;
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
