package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "stok", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stokId;

    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urunler urun;

    @Column(nullable = false)
    private int miktar;

    private String depoKonumu;
}
