package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.Stok;
import tr.edu.ogu.ceng.product.repository.StokRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StokService {

    private final StokRepository stokRepository;

    public StokService(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }

    // ID'ye göre stok getir
    public Stok getStokById(Long id) {
        return stokRepository.findById(id).orElse(null);
    }

    // Tüm stok kayıtlarını getir
    public List<Stok> getAllStok() {
        return stokRepository.findAll();
    }

    // Yeni stok kaydı oluştur
    public Stok createStok(Stok stok) {
        return stokRepository.save(stok);
    }

    // Mevcut bir stok kaydını güncelle
    public Stok updateStok(Long id, Stok updatedStok) {
        Optional<Stok> existingStok = stokRepository.findById(id);
        if (existingStok.isPresent()) {
            Stok stok = existingStok.get();
            stok.setMiktar(updatedStok.getMiktar());
            stok.setDepoKonumu(updatedStok.getDepoKonumu());
            return stokRepository.save(stok);
        }
        return null; // Güncelleme yapılmazsa null döner
    }

    // ID'ye göre stok kaydını sil
    public void deleteStok(Long id) {
        stokRepository.deleteById(id);
    }

	
}
