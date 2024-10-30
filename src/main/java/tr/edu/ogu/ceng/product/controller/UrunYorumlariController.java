package tr.edu.ogu.ceng.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.product.model.UrunYorumlari;
import tr.edu.ogu.ceng.product.service.UrunYorumlariService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/urun-yorumlari")
public class UrunYorumlariController {

    private final UrunYorumlariService urunYorumlariService;

    @Autowired
    public UrunYorumlariController(UrunYorumlariService urunYorumlariService) {
        this.urunYorumlariService = urunYorumlariService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrunYorumlari> getYorumById(@PathVariable Long id) {
        UrunYorumlari yorum = urunYorumlariService.findById(id);
        return ResponseEntity.ok(yorum);
    }

    @GetMapping
    public ResponseEntity<List<UrunYorumlari>> getAllYorumlar() {
        List<UrunYorumlari> yorumlar = urunYorumlariService.findAll();
        return ResponseEntity.ok(yorumlar);
    }

    @PostMapping
    public ResponseEntity<UrunYorumlari> createYorum(@RequestBody UrunYorumlari yorum) {
        UrunYorumlari createdYorum = urunYorumlariService.save(yorum);
        return ResponseEntity.ok(createdYorum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UrunYorumlari> updateYorum(@PathVariable Long id, @RequestBody UrunYorumlari yorumDetails) {
        UrunYorumlari updatedYorum = urunYorumlariService.update(id, yorumDetails);
        return ResponseEntity.ok(updatedYorum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYorum(@PathVariable Long id) {
        urunYorumlariService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
