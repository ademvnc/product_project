package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.Urunler;
import tr.edu.ogu.ceng.product.service.UrunlerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/urunler")
public class UrunlerController {

    private final UrunlerService urunlerService;

    // ID ile ürün getir
    @GetMapping("/{id}")
    public Urunler getUrunById(@PathVariable Long id) {
        return urunlerService.getUrunById(id);
    }
    
    // Ürün adı ile arama yap
    @GetMapping("/findByAd")
    public List<Urunler> findByAd(@RequestParam String ad) {
        return urunlerService.findByAd(ad);
    }

    // Kategori ID'sine göre ürün getir
    @GetMapping("/findByKategori")
    public List<Urunler> findByKategori(@RequestParam Long kategoriId) {
        return urunlerService.findByKategori(kategoriId);
    }

    // Fiyat aralığına göre ürün getir
    @GetMapping("/findByFiyatAraligi")
    public List<Urunler> findByFiyatAraligi(@RequestParam BigDecimal minFiyat, @RequestParam BigDecimal maxFiyat) {
        return urunlerService.findByFiyatBetween(minFiyat, maxFiyat);
    }

    // Getter metodu
    public UrunlerService getUrunlerService() {
        return urunlerService;
    }
}
