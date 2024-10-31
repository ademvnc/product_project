package tr.edu.ogu.ceng.product.model;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
@Table(name = "stok", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stok extends BaseEntity {

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