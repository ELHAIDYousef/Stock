package ma.iticsolution.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor
@NoArgsConstructor
public class Client extends Actor{

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<CommandClient> commands;
}
