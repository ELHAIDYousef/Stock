package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    List<Category> findCategoryByNameContains(String name);
}
