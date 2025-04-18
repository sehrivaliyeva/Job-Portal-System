
package projects.jobportalsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.jobportalsystem.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
