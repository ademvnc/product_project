package tr.edu.ogu.ceng.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "urunler", schema = "urun")
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urunId;

    @Column(nullable = false, length = 255)
    private String ad;

    private String aciklama;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal fiyat;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategoriler kategori;
   
    @ManyToMany(mappedBy = "urunler")
    private Set<UrunEtiketleri> etiketler;

    @Column(nullable = false)
    private int stokMiktari;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime eklenmeTarihi;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime guncellenmeTarihi;

    // Getter ve Setter metodları
    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public Kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(Kategoriler kategori) {
        this.kategori = kategori;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public LocalDateTime getEklenmeTarihi() {
        return eklenmeTarihi;
    }

    public void setEklenmeTarihi(LocalDateTime eklenmeTarihi) {
        this.eklenmeTarihi = eklenmeTarihi;
    }

    public LocalDateTime getGuncellenmeTarihi() {
        return guncellenmeTarihi;
    }

    public void setGuncellenmeTarihi(LocalDateTime guncellenmeTarihi) {
        this.guncellenmeTarihi = guncellenmeTarihi;
    }
}
