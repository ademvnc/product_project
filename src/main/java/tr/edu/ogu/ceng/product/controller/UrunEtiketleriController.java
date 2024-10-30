package tr.edu.ogu.ceng.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.edu.ogu.ceng.product.model.UrunEtiketleri;
import tr.edu.ogu.ceng.product.service.UrunEtiketleriService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/urun-etiketleri") // Endpoint address
public class UrunEtiketleriController {

    private final UrunEtiketleriService urunEtiketleriService; // UrunEtiketleriService dependency

    @GetMapping("/{id}")
    public UrunEtiketleri getUrunEtiketi(@PathVariable Long id) {
        return urunEtiketleriService.getUrunEtiketiById(id); // Retrieve product tag by ID
    }

    @GetMapping
    public List<UrunEtiketleri> getAllUrunEtiketleri() {
        return urunEtiketleriService.getAllUrunEtiketleri(); // Retrieve all product tags
    }
    
    // Getter method
    public UrunEtiketleriService getUrunEtiketleriService() {
        return urunEtiketleriService;
    }
}
