package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Category;
import ma.iticsolution.stock.repository.CategoryRepo;
import ma.iticsolution.stock.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category addCategory(Category c) {
        return categoryRepo.save(c);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public Category updateCategory(Category c, Long id) {
        c.setId(id);
        return categoryRepo.save(c);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        return categoryRepo.findCategoryByNameContainsOrderByNameAsc(name);
    }
}
