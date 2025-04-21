package projects.jobportalsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projects.jobportalsystem.dto.reponse.EmployerResponse;
import projects.jobportalsystem.dto.request.EmployerRequest;
import projects.jobportalsystem.entity.Employer;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    @Mapping(target = "id", ignore = true)
   @Mapping(target = "vacancies", ignore = true)
    Employer toEntity(EmployerRequest request);

    EmployerResponse toResponse(Employer employer);
}