package ma.iticsolution.stock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class CommandClient extends Command{

    @OneToMany(mappedBy = "command")
    private List<LineCommandClient> lcClient;
    @ManyToOne
    private Client client;
    @OneToOne
    private FactureClient factureClient;
}
