package tr.edu.ogu.ceng.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Table(name = "urun_yorumlari", schema = "urun")
public class UrunYorumlari extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yorumId;

    @ManyToOne
    @JoinColumn(name = "urun_id", nullable = false)
    private Urunler urun;

    @Column(nullable = false)
    private int musteriId;

    @Column(nullable = false)
    private int puan;

    private String yorum;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime yorumTarihi;

    // Getter and Setter methods
    public Long getYorumId() {
        return yorumId;
    }

    public void setYorumId(Long yorumId) {
        this.yorumId = yorumId;
    }

    public Urunler getUrun() {
        return urun;
    }

    public void setUrun(Urunler urun) {
        this.urun = urun;
    }

    public int getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        if (puan < 1 || puan > 5) {
            throw new IllegalArgumentException("Puan 1 ile 5 arasında olmalıdır.");
        }
        this.puan = puan;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public LocalDateTime getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(LocalDateTime yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }
}
