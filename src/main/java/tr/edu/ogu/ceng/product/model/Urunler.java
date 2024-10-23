package tr.edu.ogu.ceng.product.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Urunler", schema = "urun")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urunId;

    @Column(nullable = false)
    private String ad;

    private String aciklama;

    @Column(nullable = false)
    private BigDecimal fiyat;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategoriler kategori;

    @Column(nullable = false)
    private int stokMiktari;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime eklenmeTarihi;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime guncellenmeTarihi;

    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UrunResimleri> resimler;

    @ManyToMany
    @JoinTable(
        name = "Urun_Etiket_Iliski",
        schema = "urun",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "etiket_id")
    )
    private Set<UrunEtiketleri> etiketler;

    @OneToMany(mappedBy = "urun", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UrunYorumlari> yorumlar;
}

