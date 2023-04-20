package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Category;

import java.util.List;

public interface CategoryService {

    //List<Category> findAllCategorys();
    Category addCategory(Category c);
    Category findCategoryById(Long id);
    Category updateCategory(Category c , Long id);
    void deleteCategory(Long id);
    List<Category> findCategoryByName(String name);
}
