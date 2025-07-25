package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Product;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;


public interface ProductService {

    //List<Product> findAllProducts();
    ResponseEntity<?> addProduct(Product p);
    Product findProductById(Long id);
    ResponseEntity<Product> updateProduct(Product p, Long id);
    boolean deleteProduct(Long id);
    List<Product> findProductByName(String name);

    String getFile();

    void addFile(MultipartFile file);

    ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException;
}
