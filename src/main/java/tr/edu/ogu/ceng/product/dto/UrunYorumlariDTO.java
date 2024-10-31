package tr.edu.ogu.ceng.product.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunYorumlariDTO {
    private Long yorumId;
    private Long urunId; // Urun nesnesinin sadece ID'sini kullanıyoruz
    private int musteriId;
    private int puan;
    private String yorum;
    private LocalDateTime yorumTarihi;

    
}
