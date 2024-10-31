package tr.edu.ogu.ceng.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "urun_resimleri", schema = "urun")
public class UrunResimleri extends BaseEntity {

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

    // Getter and Setter methods
    public Long getResimId() {
        return resimId;
    }

    public void setResimId(Long resimId) {
        this.resimId = resimId;
    }

    public Urunler getUrun() {
        return urun;
    }

    public void setUrun(Urunler urun) {
        this.urun = urun;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public boolean isAnaResim() {
        return anaResim;
    }

    public void setAnaResim(boolean anaResim) {
        this.anaResim = anaResim;
    }
}
