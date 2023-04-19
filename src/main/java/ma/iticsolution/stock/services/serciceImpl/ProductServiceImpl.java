package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.repository.ProductRepo;
import ma.iticsolution.stock.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product p) {
        return productRepo.save(p);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product updateProduct(Product p, Long id) {
        p.setId(id);
        return productRepo.save(p);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepo.findProductByNameContains(name);
    }
}
