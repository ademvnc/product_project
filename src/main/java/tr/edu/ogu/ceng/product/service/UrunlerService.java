package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.Urunler;
import tr.edu.ogu.ceng.product.repository.UrunlerRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UrunlerService {

    private final UrunlerRepository urunlerRepository;

    public UrunlerService(UrunlerRepository urunlerRepository) {
        this.urunlerRepository = urunlerRepository;
    }

    public Urunler getUrunById(Long id) {
        return urunlerRepository.findById(id).orElse(null);
    }

    public List<Urunler> findByAd(String ad) {
        return urunlerRepository.findByAd(ad);
    }

    public List<Urunler> findByKategori(Long kategoriId) {
        return urunlerRepository.findByKategori_KategoriId(kategoriId);
    }

    public List<Urunler> findByFiyatBetween(BigDecimal minFiyat, BigDecimal maxFiyat) {
        return urunlerRepository.findByFiyatBetween(minFiyat, maxFiyat);
    }

    // Getter metodu
    public UrunlerRepository getUrunlerRepository() {
        return urunlerRepository;
    }
}
