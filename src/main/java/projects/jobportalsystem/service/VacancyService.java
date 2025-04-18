package projects.jobportalsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.jobportalsystem.dto.reponse.VacancyResponse;
import projects.jobportalsystem.dto.request.VacancyRequest;
import projects.jobportalsystem.entity.Vacancy;
import projects.jobportalsystem.mapper.VacancyMapper;
import projects.jobportalsystem.repo.VacancyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    private final VacancyMapper vacancyMapper;

    public VacancyResponse createVacancy(VacancyRequest request) {
        Vacancy vacancy = vacancyMapper.toEntity(request);
        Vacancy savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.toResponse(savedVacancy);
    }

    public VacancyResponse updateVacancy(Long id, VacancyRequest request) {
        Vacancy existingVacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));

        vacancyMapper.updateEntity(existingVacancy, request);
        Vacancy updatedVacancy = vacancyRepository.save(existingVacancy);
        return vacancyMapper.toResponse(updatedVacancy);
    }

    public VacancyResponse getVacancy(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));
        return vacancyMapper.toResponse(vacancy);
    }

    public List<VacancyResponse> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();
        return vacancies.stream()
                .map(vacancyMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void deleteVacancy(Long id) {
        Vacancy existingVacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found with id: " + id));
        vacancyRepository.delete(existingVacancy);
    }
}
