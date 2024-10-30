package tr.edu.ogu.ceng.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ogu.ceng.product.model.UrunYorumlari;

public interface UrunYorumlariRepository extends JpaRepository<UrunYorumlari, Long> {
    // Custom query method to find comments by product ID
    List<UrunYorumlari> findByUrun_UrunId(Long urunId);
    
    Optional<UrunYorumlari> findById(Long id);
}