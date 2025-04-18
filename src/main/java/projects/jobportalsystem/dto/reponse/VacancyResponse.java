package projects.jobportalsystem.dto.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyResponse {

    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String email;
    private String categoryName;
    private String employerName;
}
