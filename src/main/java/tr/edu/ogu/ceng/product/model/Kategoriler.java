package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Kategoriler", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kategoriler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kategoriId;

    @Column(nullable = false)
    private String ad;

    @ManyToOne
    @JoinColumn(name = "ust_kategori_id")
    private Kategoriler ustKategori;

    @OneToMany(mappedBy = "ustKategori")
    private Set<Kategoriler> altKategoriler;
}

