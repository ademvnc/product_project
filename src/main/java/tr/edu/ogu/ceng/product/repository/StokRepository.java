package tr.edu.ogu.ceng.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ogu.ceng.product.model.Stok;

import java.util.Optional;

@Repository
public interface StokRepository extends JpaRepository<Stok, Long> {
    // Urun ID'ye göre stok kayıtlarını bulmak için custom bir metot
    Optional<Stok> findByUrun_UrunId(Long urunId);
    
    Optional<Stok> findById(Long id);
}
