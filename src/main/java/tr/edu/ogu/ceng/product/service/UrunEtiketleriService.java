package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.UrunEtiketleri;
import tr.edu.ogu.ceng.product.repository.UrunEtiketleriRepository;

import java.util.List;

@Service
public class UrunEtiketleriService {

    private final UrunEtiketleriRepository urunEtiketleriRepository;

    public UrunEtiketleriService(UrunEtiketleriRepository urunEtiketleriRepository) {
        this.urunEtiketleriRepository = urunEtiketleriRepository;
    }

    public UrunEtiketleri getUrunEtiketiById(Long id) {
        return urunEtiketleriRepository.findById(id).orElse(null); // Retrieve a specific product tag
    }

    public List<UrunEtiketleri> getAllUrunEtiketleri() {
        return urunEtiketleriRepository.findAll(); // Retrieve all product tags
    }
    
 // Yeni bir UrunEtiketleri nesnesi eklemek için metot
    public UrunEtiketleri createUrunEtiketi(UrunEtiketleri urunEtiketi) {
        return urunEtiketleriRepository.save(urunEtiketi); // Repository'deki save metodu ile nesneyi kaydet
    }
}
