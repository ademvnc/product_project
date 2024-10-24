package tr.edu.ogu.ceng.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ogu.ceng.product.model.Kategoriler;

@Repository
public interface KategorilerRepository extends JpaRepository<Kategoriler, Long> {
    // Üst kategori ID'sine göre kategorileri bulmak için özel bir metot
    List<Kategoriler> findByUstKategoriId(Long ustKategoriId);

    // Belirli bir kategori ID'si için optional metot
    Optional<Kategoriler> findById(Long id);
}
