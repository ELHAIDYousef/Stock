package ma.iticsolution.stock.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String designation;
    private double prixAchat;
    private double prixVente;
    private long quantite;
    private int tva ;
    private String imageUrl;
    @ManyToOne
    private Category category;
}