package tr.edu.ogu.ceng.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunlerDTO {
    private Long urunId;
    private String ad;
    private String aciklama;
    private BigDecimal fiyat;
    private Long kategoriId; // Kategoriler nesnesinin sadece ID'sini kullanıyoruz
    private Set<Long> etiketler; // Etiketlerin sadece ID'lerini kullanıyoruz
    private int stokMiktari;
    private LocalDateTime eklenmeTarihi;
    private LocalDateTime guncellenmeTarihi;

    
}

