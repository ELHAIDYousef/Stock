package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.entities.FactureClient;
import ma.iticsolution.stock.repository.ClientCommandRepo;
import ma.iticsolution.stock.repository.FactureClientRepo;
import ma.iticsolution.stock.services.FactureClientService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class FactureClientServiceImpl implements FactureClientService {
    final FactureClientRepo service;
    final ClientCommandRepo commandService;

    public FactureClientServiceImpl(FactureClientRepo service, ClientCommandRepo commandService) {
        this.service = service;
        this.commandService = commandService;
    }

    @Override
    public List<FactureClient> findAllFactures() {
        return service.findAll();
    }

    @Override
    public List<FactureClient> findAllFacturesClient(Long id) {
        return service.findByCommand_Client_Id(id);
    }
    @Transactional
    @Override
    public FactureClient addFacture(FactureClient ff,Long id) {
        CommandClient command = commandService.findById(id).get();
        ff.setCommand(command);
        FactureClient factureClient =  service.save(ff);

        return factureClient;
    }

    @Override
    public FactureClient findFactureById(Long id) {
        return service.findById(id).get();
    }

    @Override
    public FactureClient updateFacture(FactureClient ff, Long id) {
        ff.setId(id);
        return service.save(ff);
    }

    @Override
    public void deleteFacture(Long id) {
        service.deleteById(id);
    }

    @Override
    public FactureClient getLatestFactureClient() {
        if (service.findLatestFactureClient().toArray().length == 0){
            return new FactureClient(null,"FA-0000-0000",new Date(),new Date(),null);
        }
        return service.findLatestFactureClient().get(0);
    }
    @Override
    public ResponseEntity<byte[]> generateReport(Long id) throws FileNotFoundException, JRException {
        String path = "D:\\Courses\\Jasper Report\\Reports";
        FactureClient facture = service.findById(id).get();
        File file = ResourceUtils.getFile("classpath:facture.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(facture));
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Myself");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(print);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "facture.pdf");
        headers.setCacheControl("must-revalidate, no-store");
        headers.setPragma("no-cache");
        headers.setExpires(0);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(reportBytes);
    }


}
