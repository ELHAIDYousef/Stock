package ma.iticsolution.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurCommand extends Command{

    @JsonIgnore
    @OneToMany(mappedBy = "command")
    private List<LineCommandFournisseur> lcFournisseur;
    @ManyToOne
    private Fournisseur fournisseur;
    @OneToOne
    private FactureFournisseur factureFournisseur;
}
