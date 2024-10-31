package tr.edu.ogu.ceng.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunResimleriDTO {
    private Long resimId;
    private Long urunId; // Urun nesnesinin sadece ID'sini taşıyoruz
    private String resimUrl;
    private boolean anaResim;

    
}
