package projects.jobportalsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.jobportalsystem.dto.reponse.EmployerResponse;
import projects.jobportalsystem.dto.request.EmployerRequest;
import projects.jobportalsystem.entity.Employer;
import projects.jobportalsystem.mapper.EmployerMapper;
import projects.jobportalsystem.repo.EmployerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;

    public EmployerResponse create(EmployerRequest request) {
        Employer employer = employerMapper.toEntity(request);
        return employerMapper.toResponse(employerRepository.save(employer));
    }

    public EmployerResponse getById(Long id) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        return employerMapper.toResponse(employer);
    }

    public List<EmployerResponse> getAll() {
        return employerRepository.findAll().stream()
                .map(employerMapper::toResponse)
                .collect(Collectors.toList());
    }

    public EmployerResponse update(Long id, EmployerRequest request) {
        Employer employer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        employer.setName(request.getName());
        employer.setDescription(request.getDescription());
        return employerMapper.toResponse(employerRepository.save(employer));
    }

    public void delete(Long id) {
        if (!employerRepository.existsById(id)) {
            throw new RuntimeException("Employer not found");
        }
        employerRepository.deleteById(id);
    }
}
