package projects.jobportalsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.jobportalsystem.entity.Application;
import projects.jobportalsystem.entity.User;
import projects.jobportalsystem.entity.Vacancy;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByUserAndVacancy(User user, Vacancy vacancy);
    List<Application> findAllByUser(User user);
}