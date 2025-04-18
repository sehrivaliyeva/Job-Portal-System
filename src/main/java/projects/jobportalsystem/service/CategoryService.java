
package projects.jobportalsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projects.jobportalsystem.dto.reponse.CategoryResponse;
import projects.jobportalsystem.dto.request.CategoryRequest;
import projects.jobportalsystem.entity.Category;
import projects.jobportalsystem.mapper.CategoryMapper;
import projects.jobportalsystem.repo.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse create(CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toResponse(category);
    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(request.getCategoryName());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
