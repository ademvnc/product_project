package tr.edu.ogu.ceng.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kategoriler", schema = "urun") // Tablo adını ve şemasını ayarlayın
public class Kategoriler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kategoriId;
    private String ad; // Kategori adı için bir alan
    private Long ustKategoriId; // Kategori açıklaması için bir alan (isteğe bağlı)

    // Getter ve Setter metodları
    public Long getkategoriId() {
        return kategoriId;
    }

    public void setkategoriId(Long kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getName() {
        return ad;
    }

    public void setName(String ad) {
        this.ad = ad;
    }

    public Long getustKategoriId() {
        return ustKategoriId;
    }

    public void setustKategoriId(Long ustKategoriId) {
        this.ustKategoriId = ustKategoriId;
    }
}
