package ma.iticsolution.stock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineCommandFournisseur extends LineCommand{
    @ManyToOne
    private CommandFournisseur command;
    @OneToOne
    private Product product;
}
