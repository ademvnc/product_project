package tr.edu.ogu.ceng.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ogu.ceng.product.model.UrunEtiketleri;

@Repository
public interface UrunEtiketleriRepository extends JpaRepository<UrunEtiketleri, Long> {
    // Belirli bir etiket adı için etiketleri bulmak için özel bir metot
    Optional<UrunEtiketleri> findByEtiketAd(String etiketAd);

    // Belirli bir etiket ID'si için optional metot
    Optional<UrunEtiketleri> findById(Long id);

    // Tüm etiketleri bulmak için
    List<UrunEtiketleri> findAll();
}
