package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Category;
import ma.iticsolution.stock.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(name = "id") Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("")
    public List<Category> getCategoryByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return categoryService.findCategoryByName(name);
    }

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update-category/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable Long id) {
        return categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/delete-category/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
    }
}
