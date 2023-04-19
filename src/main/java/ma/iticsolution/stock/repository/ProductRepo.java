package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findProductByNameContains(String name);
}
