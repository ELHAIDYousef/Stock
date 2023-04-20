package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Product;

import java.util.List;


public interface ProductService {

    //List<Product> findAllProducts();
    Product addProduct(Product p);
    Product findProductById(Long id);
    Product updateProduct(Product p , Long id);
    void deleteProduct(Long id);
    List<Product> findProductByName(String name);

}
