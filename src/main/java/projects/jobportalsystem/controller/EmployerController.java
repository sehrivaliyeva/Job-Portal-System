package projects.jobportalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.jobportalsystem.dto.reponse.EmployerResponse;
import projects.jobportalsystem.dto.request.EmployerRequest;
import projects.jobportalsystem.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("v1/employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping
    public ResponseEntity<EmployerResponse> create(@RequestBody EmployerRequest request) {
        return ResponseEntity.ok(employerService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployerResponse>> getAll() {
        return ResponseEntity.ok(employerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployerResponse> update(@PathVariable Long id, @RequestBody EmployerRequest request) {
        return ResponseEntity.ok(employerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
