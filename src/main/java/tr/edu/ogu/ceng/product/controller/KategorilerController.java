package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.Kategoriler;
import tr.edu.ogu.ceng.product.service.KategorilerService; // KategorilerService sınıfının import edilmesi gerekiyor

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kategoriler") // Endpoint adresini ayarlayın
public class KategorilerController {

    private final KategorilerService kategorilerService; // KategorilerService'i tanımlayın

    @GetMapping("/{id}")
    public Kategoriler getKategori(@PathVariable Long id) {
        return kategorilerService.getKategoriById(id); // KategorilerService'i kullanarak Kategoriler nesnesini döndürün
    }

    @GetMapping("/getByUstKategori")
    public List<Kategoriler> getByUstKategori(@RequestParam Long ustKategoriId) {
        return kategorilerService.getKategorilerByUstKategoriId(ustKategoriId); // Üst kategoriye göre kategorileri döndür
    }
    
    // Getter metodu
    public KategorilerService getKategorilerService() {
        return kategorilerService;
    }
}
