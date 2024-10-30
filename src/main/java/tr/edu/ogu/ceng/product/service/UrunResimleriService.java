package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.UrunResimleri;
import tr.edu.ogu.ceng.product.repository.UrunResimleriRepository;


@Service
@RequiredArgsConstructor
public class UrunResimleriService {

    private final UrunResimleriRepository urunResimleriRepository;

    public UrunResimleri getUrunResimleriById(Long id) {
        return urunResimleriRepository.findById(id).orElse(null);
    }
    
    // Yeni bir Kategoriler nesnesi eklemek için metot
    public UrunResimleri createKategori(UrunResimleri urunresimleri) {
        return urunResimleriRepository.save(urunresimleri); // Repository'deki save metodu ile nesneyi kaydet
    }
}