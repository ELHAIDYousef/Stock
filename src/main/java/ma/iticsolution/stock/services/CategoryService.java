package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Category;

import java.util.List;

public interface CategoryService {

    //public List<Category> findAllCategorys();
    public Category addCategory(Category c);
    public Category findCategoryById(Long id);
    public Category updateCategory(Category c , Long id);
    public void deleteCategory(Long id);
    public List<Category> findCategoryByName(String name);
}
