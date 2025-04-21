package projects.jobportalsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.jobportalsystem.dto.reponse.ApplicationResponse;
import projects.jobportalsystem.dto.reponse.AppliedVacancyDto;
import projects.jobportalsystem.entity.Application;
import projects.jobportalsystem.entity.User;
import projects.jobportalsystem.entity.Vacancy;
import projects.jobportalsystem.repo.ApplicationRepository;
import projects.jobportalsystem.repo.VacancyRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final VacancyRepository vacancyRepository;

    public ApplicationResponse applyToVacancy(Long vacancyId, User user) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new RuntimeException("Vakansiya tapılmadı"));

        boolean alreadyApplied = applicationRepository.existsByUserAndVacancy(user, vacancy);
        if (alreadyApplied) {
            throw new RuntimeException("Bu vakansiyaya artıq müraciət etmisiniz");
        }

        Application application = new Application();
        application.setUser(user);
        application.setVacancy(vacancy);
        application.setAppliedAt(LocalDateTime.now());
        applicationRepository.save(application);

        return new ApplicationResponse(
                "CV göndərmək üçün email ünvanını kopyalayın",
                vacancy.getName(),
                vacancy.getEmail()
        );
    }

    public List<AppliedVacancyDto> getMyApplications(User user) {
        List<Application> applications = applicationRepository.findAllByUser(user);

        return applications.stream()
                .map(app -> new AppliedVacancyDto(
                        app.getVacancy().getId(),
                        app.getVacancy().getName(),
                        app.getVacancy().getEmail(),
                        app.getAppliedAt().toString()
                )).collect(Collectors.toList());
    }
}
