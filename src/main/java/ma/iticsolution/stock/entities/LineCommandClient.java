package ma.iticsolution.stock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor@NoArgsConstructor
public class LineCommandClient extends LineCommand{


    private double montantTTC;
    private double montantTVA;
    private double montantHT;
    private int tauxR;
    @ManyToOne
    private CommandClient command;
    @OneToOne
    private Product product;
}
