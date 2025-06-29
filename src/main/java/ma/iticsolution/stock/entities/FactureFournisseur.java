package ma.iticsolution.stock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureFournisseur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String codeFacture;
        @Temporal(TemporalType.TIMESTAMP)
        private Date dateFacture;
        @Temporal(TemporalType.TIMESTAMP)
        private Date echeance;
        @OneToOne
        private CommandFournisseur command;

}
