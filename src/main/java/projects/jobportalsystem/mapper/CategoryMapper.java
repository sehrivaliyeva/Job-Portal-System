package projects.jobportalsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projects.jobportalsystem.dto.reponse.CategoryResponse;
import projects.jobportalsystem.dto.request.CategoryRequest;
import projects.jobportalsystem.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vacancies", ignore = true)
    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);
}