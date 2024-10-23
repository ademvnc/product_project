package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Urun_Yorumlari", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunYorumlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yorumId;

    @ManyToOne
    @JoinColumn(name = "urun_id")
    private Urunler urun;

    private int musteriId;

    @Column(nullable = false)
    private int puan;

    private String yorum;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime yorumTarihi;
}
