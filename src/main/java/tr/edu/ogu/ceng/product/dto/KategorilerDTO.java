package tr.edu.ogu.ceng.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KategorilerDTO {
    private Long kategoriId;
    private String ad;
    private Long ustKategoriId;

    
}

