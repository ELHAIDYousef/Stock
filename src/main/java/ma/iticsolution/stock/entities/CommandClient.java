package ma.iticsolution.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class CommandClient extends Command{

    @OneToMany(mappedBy = "command",cascade = CascadeType.ALL)
    private List<LineCommandClient> lcClient;
    @ManyToOne
    private Client client;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private FactureClient factureClient;
}
