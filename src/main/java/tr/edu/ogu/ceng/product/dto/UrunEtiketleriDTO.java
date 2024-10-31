package tr.edu.ogu.ceng.product.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunEtiketleriDTO {
    private Long etiketId;
    private String etiketAd;
    private Set<Long> urunler; // Urun nesnelerinin sadece ID'lerini taşıyoruz

    
}
