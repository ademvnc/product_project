package tr.edu.ogu.ceng.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StokDTO {
    private Long stokId;
    private Long urunId; // Urun nesnesinin sadece ID'sini kullanıyoruz
    private int miktar;
    private String depoKonumu;

    
}

