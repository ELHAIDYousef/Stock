package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
@CrossOrigin("*")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> getProductByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return productService.findProductByName(name);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product p) {
        return productService.addProduct(p);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable(name = "id") Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/image")
    public ResponseEntity<String> getImage(){
        return ResponseEntity.ok(productService.getFile());
    }

    @PutMapping("/image")
    public void addFile(@RequestParam("file") MultipartFile file) {
        productService.addFile(file);
    }
}
