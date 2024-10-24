package tr.edu.ogu.ceng.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ogu.ceng.product.model.UrunResimleri;

public interface UrunResimleriRepository extends JpaRepository<UrunResimleri, Long> {
    UrunResimleri findByUrun_UrunId(Long urunId); // Belirli bir ürünün resmini bulmak için custom query
    
    Optional<UrunResimleri> findById(Long id);
}
