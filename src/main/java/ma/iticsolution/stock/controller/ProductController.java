package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("")
    public List<Product> getProductByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return productService.findProductByName(name);
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update-product/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
    }
}
