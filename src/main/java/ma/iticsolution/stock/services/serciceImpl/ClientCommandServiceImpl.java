package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Client;
import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.entities.Product;
import ma.iticsolution.stock.repository.ClientCommandRepo;
import ma.iticsolution.stock.services.ClientCommandService;
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
public class ClientCommandServiceImpl implements ClientCommandService {

    final ClientCommandRepo ccRepo;

    public ClientCommandServiceImpl(ClientCommandRepo ccRepo) {
        this.ccRepo = ccRepo;
    }


    @Override
    public List<CommandClient> findAllCommands() {
        return ccRepo.findAll();
    }

    @Override
    public CommandClient addCommand(CommandClient cc) {
        return ccRepo.save(cc);
    }

    @Override
    public CommandClient findCommandById(Long id) {
        System.out.println("id !!!!!!!!!! : "+id);
        return ccRepo.findById(id).get();
    }

    @Override
    public CommandClient updateCommand(CommandClient cc, Long id) {
        cc.setId(id);
        return ccRepo.save(cc);
    }

    @Override
    public void deleteCommand(Long id) {
        ccRepo.deleteById(id);
    }

    @Override
    public List<CommandClient> findCommandByEtat(String etat) {
        return ccRepo.findCommandByEtat(etat);
    }


    @Override
    public ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException {
        List<CommandClient> commands = ccRepo.findOrderByName();
        File file = ResourceUtils.getFile("classpath:clientsCommands.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(commands);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Myself");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        byte[] reportBytes = JasperExportManager.exportReportToPdf(print);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "clients_commands.pdf");
        headers.setCacheControl("must-revalidate, no-store");
        headers.setPragma("no-cache");
        headers.setExpires(0);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(reportBytes);
    }
}
