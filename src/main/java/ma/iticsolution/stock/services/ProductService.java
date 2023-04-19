package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Product;

import java.util.List;


public interface ProductService {

    //public List<Product> findAllProducts();
    public Product addProduct(Product p);
    public Product findProductById(Long id);
    public Product updateProduct(Product p , Long id);
    public void deleteProduct(Long id);
    public List<Product> findProductByName(String name);

}
