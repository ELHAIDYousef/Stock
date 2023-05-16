package ma.iticsolution.stock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class FactureClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @Temporal(TemporalType.DATE)
    private Date echeance;
    @OneToOne
    private CommandClient command;
}
