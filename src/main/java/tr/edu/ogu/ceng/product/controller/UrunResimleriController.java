package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.UrunResimleri;
import tr.edu.ogu.ceng.product.service.UrunResimleriService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/urun-resimleri")
@RequiredArgsConstructor
public class UrunResimleriController {

    private final UrunResimleriService urunResimleriService;

    @GetMapping("/{id}")
    public UrunResimleri getUrunResimleriById(@PathVariable Long id) {
        return urunResimleriService.getUrunResimleriById(id);
    }
}