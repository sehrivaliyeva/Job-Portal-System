package projects.jobportalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.jobportalsystem.dto.reponse.VacancyResponse;
import projects.jobportalsystem.dto.request.VacancyRequest;
import projects.jobportalsystem.service.VacancyService;

import java.util.List;

@RestController
@RequestMapping("v1/vacancy")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<VacancyResponse> createVacancy(@RequestBody VacancyRequest request) {
        VacancyResponse vacancyResponse = vacancyService.createVacancy(request);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacancyResponse> updateVacancy(@PathVariable Long id, @RequestBody VacancyRequest request) {
        VacancyResponse vacancyResponse = vacancyService.updateVacancy(id, request);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyResponse> getVacancy(@PathVariable Long id) {
        VacancyResponse vacancyResponse = vacancyService.getVacancy(id);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VacancyResponse>> getAllVacancies() {
        List<VacancyResponse> vacancyResponses = vacancyService.getAllVacancies();
        return new ResponseEntity<>(vacancyResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
