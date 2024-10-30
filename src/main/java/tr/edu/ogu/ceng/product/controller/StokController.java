package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.Stok;
import tr.edu.ogu.ceng.product.service.StokService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stok")
public class StokController {

    private final StokService stokService;

    // ID'ye göre stok bilgisi getir
    @GetMapping("/{id}")
    public Stok getStokById(@PathVariable Long id) {
        return stokService.getStokById(id);
    }

    // Tüm stok bilgilerini getir
    @GetMapping
    public List<Stok> getAllStok() {
        return stokService.getAllStok();
    }

    // Yeni stok kaydı oluştur
    @PostMapping
    public Stok createStok(@RequestBody Stok stok) {
        return stokService.createStok(stok);
    }

    // Stok miktarını güncelle
    @PutMapping("/{id}")
    public Stok updateStok(@PathVariable Long id, @RequestBody Stok stok) {
        return stokService.updateStok(id, stok);
    }

    // ID'ye göre stok kaydını sil
    @DeleteMapping("/{id}")
    public void deleteStok(@PathVariable Long id) {
        stokService.deleteStok(id);
    }
}
