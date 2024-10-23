package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Urun_Etiketleri", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunEtiketleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etiketId;

    @Column(nullable = false)
    private String etiketAd;

    @ManyToMany(mappedBy = "etiketler")
    private Set<Urunler> urunler;
}
