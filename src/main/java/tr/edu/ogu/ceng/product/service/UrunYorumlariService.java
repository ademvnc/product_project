package tr.edu.ogu.ceng.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.UrunYorumlari;
import tr.edu.ogu.ceng.product.repository.UrunYorumlariRepository;

import java.util.List;

@Service
public class UrunYorumlariService {

    private final UrunYorumlariRepository urunYorumlariRepository;

    @Autowired
    public UrunYorumlariService(UrunYorumlariRepository urunYorumlariRepository) {
        this.urunYorumlariRepository = urunYorumlariRepository;
    }

    public UrunYorumlari findById(Long id) {
        return urunYorumlariRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yorum bulunamadı: " + id));
    }

    public List<UrunYorumlari> findAll() {
        return urunYorumlariRepository.findAll();
    }

    public UrunYorumlari save(UrunYorumlari yorum) {
        return urunYorumlariRepository.save(yorum);
    }

    public UrunYorumlari update(Long id, UrunYorumlari yorumDetails) {
        UrunYorumlari existingYorum = findById(id);
        existingYorum.setUrun(yorumDetails.getUrun());
        existingYorum.setMusteriId(yorumDetails.getMusteriId());
        existingYorum.setPuan(yorumDetails.getPuan());
        existingYorum.setYorum(yorumDetails.getYorum());
        // Set any other fields that may need updating here
        return urunYorumlariRepository.save(existingYorum);
    }

    public void delete(Long id) {
        UrunYorumlari existingYorum = findById(id);
        urunYorumlariRepository.delete(existingYorum);
    }
}
