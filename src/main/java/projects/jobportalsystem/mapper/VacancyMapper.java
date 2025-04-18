package projects.jobportalsystem.mapper;

import org.springframework.stereotype.Component;
import projects.jobportalsystem.dto.reponse.VacancyResponse;
import projects.jobportalsystem.dto.request.VacancyRequest;
import projects.jobportalsystem.entity.Category;
import projects.jobportalsystem.entity.Employer;
import projects.jobportalsystem.entity.Vacancy;
import projects.jobportalsystem.repo.CategoryRepository;
import projects.jobportalsystem.repo.EmployerRepository;

@Component
public class VacancyMapper {

    private final CategoryRepository categoryRepository;
    private final EmployerRepository employerRepository;

    public VacancyMapper(CategoryRepository categoryRepository, EmployerRepository employerRepository) {
        this.categoryRepository = categoryRepository;
        this.employerRepository = employerRepository;
    }

    // VacancyRequest -> Vacancy
    public Vacancy toEntity(VacancyRequest request) {
        if (request == null) {
            return null;
        }

        Vacancy vacancy = new Vacancy();
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());

        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            vacancy.setCategory(category);
        }

        if (request.getEmployerId() != null) {
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(() -> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }

        return vacancy;
    }

    public VacancyResponse toResponse(Vacancy vacancy) {
        if (vacancy == null) {
            return null;
        }
        VacancyResponse response = new VacancyResponse();
        response.setId(vacancy.getId());
        response.setName(vacancy.getName());
        response.setDescription(vacancy.getDescription());
        response.setStartDate(vacancy.getStartDate());
        response.setEndDate(vacancy.getEndDate());
        response.setEmail(vacancy.getEmail());


        if (vacancy.getCategory() != null) {
            response.setCategoryName(vacancy.getCategory().getCategoryName());
        }

        if (vacancy.getEmployer() != null) {
            response.setEmployerName(vacancy.getEmployer().getName());
        }

        return response;
    }
    public void updateEntity(Vacancy vacancy, VacancyRequest request) {
        if (request == null) {
            return;
        }
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());


        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            vacancy.setCategory(category);
        }

        if (request.getEmployerId() != null) {
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(() -> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }
    }
}
