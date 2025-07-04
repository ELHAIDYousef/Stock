package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.CommandFournisseur;
import ma.iticsolution.stock.repository.FournisseurCommandRepo;
import ma.iticsolution.stock.services.FournisseurCommandService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FournisseurCommandServiceImpl implements FournisseurCommandService {

    final FournisseurCommandRepo fcRepo;

    public FournisseurCommandServiceImpl(FournisseurCommandRepo fcRepo) {
        this.fcRepo = fcRepo;
    }


    @Override
    public List<CommandFournisseur> findAllCommands() {
        return fcRepo.findAll();
    }

    @Override
    public CommandFournisseur addCommand(CommandFournisseur fc) {
        return fcRepo.save(fc);
    }

    @Override
    public CommandFournisseur findCommandById(Long id) {
        return fcRepo.findById(id).get();
    }

    @Override
    public CommandFournisseur updateCommand(CommandFournisseur fc, Long id) {
        fc.setId(id);
        return fcRepo.save(fc);
    }

    @Override
    public void deleteCommand(Long id) {
        fcRepo.deleteById(id);
    }

    @Override
    public List<CommandFournisseur> findCommandByEtat(String etat) {
        return fcRepo.findCommandByEtat(etat);
    }

    @Override
    public ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException {
        List<CommandFournisseur> commands = fcRepo.findOrderByName();
        File file = ResourceUtils.getFile("classpath:fournisseursCommands.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(commands);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Myself");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(print);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "fournisseurs_commands.pdf");
        headers.setCacheControl("must-revalidate, no-store");
        headers.setPragma("no-cache");
        headers.setExpires(0);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(reportBytes);
    }
}
