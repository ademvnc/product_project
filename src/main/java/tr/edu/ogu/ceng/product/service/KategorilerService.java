package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.Kategoriler;
import tr.edu.ogu.ceng.product.repository.KategorilerRepository;

import java.util.List;

@Service
public class KategorilerService {

    private final KategorilerRepository kategorilerRepository;

    public KategorilerService(KategorilerRepository kategorilerRepository) {
        this.kategorilerRepository = kategorilerRepository;
    }

    public Kategoriler getKategoriById(Long id) {
        return kategorilerRepository.findById(id).orElse(null); // Belirli bir kategoriyi döndür
    }

    public List<Kategoriler> getKategorilerByUstKategoriId(Long ustKategoriId) {
        return kategorilerRepository.findByUstKategoriId(ustKategoriId); // Üst kategori ID'sine göre kategorileri döndür
    }
    
 // Yeni bir Kategoriler nesnesi eklemek için metot
    public Kategoriler createKategori(Kategoriler kategori) {
        return kategorilerRepository.save(kategori); // Repository'deki save metodu ile nesneyi kaydet
    }
}
