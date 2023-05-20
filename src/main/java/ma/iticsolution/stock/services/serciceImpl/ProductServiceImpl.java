package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.repository.ProductRepo;
import ma.iticsolution.stock.services.ProductService;
import ma.iticsolution.stock.services.utils.FilesStorageService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Override
    public ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException {
        String path = "D:\\Courses\\Jasper Report\\Reports";
        List<Product> products = productRepo.findOrderByName();
        File file = ResourceUtils.getFile("classpath:products.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Myself");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(print);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "products.pdf");
        headers.setCacheControl("must-revalidate, no-store");
        headers.setPragma("no-cache");
        headers.setExpires(0);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(reportBytes);
    }


}
