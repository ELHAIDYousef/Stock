package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.repository.ProductRepo;
import ma.iticsolution.stock.services.ProductService;
import ma.iticsolution.stock.services.utils.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    final ProductRepo productRepo;

    @Autowired
    FilesStorageService filesStorageService ;

    private final String pathFolder = "produitImages";

    private static Product currentProduct  =null;



    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ResponseEntity<?> addProduct(Product produit) {


            currentProduct=productRepo.save(produit);


        return ResponseEntity.ok(produit);
    }

    @Override
    public Product findProductById(Long id) {
        currentProduct =productRepo.findById(id).get();
        return currentProduct;
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product p, Long id) {
        currentProduct = productRepo.findById(id).orElse(null);
        p.setId(id);
        p.setImageUrl(currentProduct.getImageUrl());
        currentProduct = productRepo.save(p);
        return ResponseEntity.ok(p);
    }

    @Override
    public boolean deleteProduct(Long id) {
        currentProduct = productRepo.findById(id).orElse(null);
            filesStorageService.deleteFile(pathFolder + "/" + currentProduct.getImageUrl());
            productRepo.deleteById(id);
            return true;
    }
    @Override
    public List<Product> findProductByName(String name) {
        return productRepo.findProductByNameContains(name);
    }

    @Override
    public String getFile() {
        return filesStorageService.loadFile(pathFolder+"/"+currentProduct.getImageUrl());
    }

    @Override
    public void addFile(MultipartFile file) {
        if(currentProduct.getImageUrl() !=null){
            filesStorageService.deleteFile(pathFolder+"/"+currentProduct.getImageUrl());
        }
        currentProduct.setImageUrl(filesStorageService.uploadFile(file,pathFolder));
        currentProduct =productRepo.save(currentProduct);
    }
}
