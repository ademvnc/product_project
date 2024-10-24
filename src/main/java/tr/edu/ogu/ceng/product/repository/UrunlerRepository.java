package tr.edu.ogu.ceng.product.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ogu.ceng.product.model.Urunler;

@Repository
public interface UrunlerRepository extends JpaRepository<Urunler, Long> {
    
    // Ürün adını kullanarak ürünleri bulmak için özel bir metot
    List<Urunler> findByAd(String ad);

    // Kategori ID'sine göre ürünleri bulmak için özel bir metot
    List<Urunler> findByKategori_KategoriId(Long kategoriId);

    // Fiyat aralığına göre ürünleri bulmak için özel bir metot
    List<Urunler> findByFiyatBetween(BigDecimal minFiyat, BigDecimal maxFiyat);
    
    // Belirli bir ürün ID'si için optional metot
    Optional<Urunler> findById(Long id);
}
