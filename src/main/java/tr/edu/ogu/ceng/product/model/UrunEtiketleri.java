package tr.edu.ogu.ceng.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import java.util.Set;

@Entity
@Table(name = "urun_etiketleri", schema = "urun")
public class UrunEtiketleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etiketId;

    @Column(nullable = false)
    private String etiketAd;

    @ManyToMany
    @JoinTable(
        name = "urun_etiket_iliski",
        joinColumns = @JoinColumn(name = "etiket_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private Set<Urunler> urunler;
    
    /*@ManyToMany(mappedBy = "etiketler")
    private Set<Urunler> urunler;*/

    // Getter and Setter methods
    public Long getEtiketId() {
        return etiketId;
    }

    public void setEtiketId(Long etiketId) {
        this.etiketId = etiketId;
    }

    public String getEtiketAd() {
        return etiketAd;
    }

    public void setEtiketAd(String etiketAd) {
        this.etiketAd = etiketAd;
    }

    public Set<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(Set<Urunler> urunler) {
        this.urunler = urunler;
    }
}
