package ma.iticsolution.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity  @AllArgsConstructor @NoArgsConstructor
public class FactureClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @Temporal(TemporalType.DATE)
    private Date echeance;
    @OneToOne(cascade = CascadeType.ALL)
    private CommandClient command;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeFacture() {
        return codeFacture;
    }

    public void setCodeFacture(String codeFacture) {
        this.codeFacture = codeFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }
    public CommandClient getCommand() {
        return command;
    }

    public void setCommand(CommandClient command) {
        this.command = command;
    }
}
