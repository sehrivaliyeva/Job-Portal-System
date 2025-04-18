package projects.jobportalsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.jobportalsystem.entity.Employer;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
