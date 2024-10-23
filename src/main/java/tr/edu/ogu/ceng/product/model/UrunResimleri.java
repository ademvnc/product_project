package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Urun_Resimleri", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunResimleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resimId;

    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urunler urun;

    @Column(nullable = false)
    private String resimUrl;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean anaResim;
}
