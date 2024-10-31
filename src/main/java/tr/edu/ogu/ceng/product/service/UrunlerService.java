package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.Urunler;
import tr.edu.ogu.ceng.product.repository.UrunlerRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UrunlerService {

    private final UrunlerRepository urunlerRepository;

    public UrunlerService(UrunlerRepository urunlerRepository) {
        this.urunlerRepository = urunlerRepository;
    }

    public Urunler getUrunById(Long id) {
        return urunlerRepository.findById(id).orElse(null);
    }

    public List<Urunler> findByAd(String ad) {
        return urunlerRepository.findByAd(ad);
    }

    public List<Urunler> findByKategori(Long kategoriId) {
        return urunlerRepository.findByKategori_KategoriId(kategoriId);
    }

    public List<Urunler> findByFiyatBetween(BigDecimal minFiyat, BigDecimal maxFiyat) {
        return urunlerRepository.findByFiyatBetween(minFiyat, maxFiyat);
    }

    // Getter metodu
    public UrunlerRepository getUrunlerRepository() {
        return urunlerRepository;
    }
    
    // Yeni bir Kategoriler nesnesi eklemek için metot
    public Urunler createKategori(Urunler urunler) {
        return urunlerRepository.save(urunler); // Repository'deki save metodu ile nesneyi kaydet
    }

	public List<Urunler> getAllUrunler() {
		 return urunlerRepository.findAll();
	}

	public Urunler addUrun(Urunler urun) {
		 return urunlerRepository.save(urun);
	}

	public boolean deleteUrun(long id) {
	    if (urunlerRepository.existsById(id)) {  // Eğer ürün mevcutsa
	        urunlerRepository.deleteById(id);    // Ürünü sil
	        return true;                         // Başarılı olduğu için true döndür
	    }
	    return false;                            // Ürün yoksa false döndür
	}

	public Urunler updateUrun(long id, Urunler updatedUrun) {
	    return urunlerRepository.findById(id).map(existingUrun -> {
	        existingUrun.setAd(updatedUrun.getAd());
	        existingUrun.setFiyat(updatedUrun.getFiyat());
	        existingUrun.setKategori(updatedUrun.getKategori());
	        // Diğer alanları da buraya ekleyebilirsiniz
	        
	        return urunlerRepository.save(existingUrun); // Güncellenmiş ürünü kaydet ve döndür
	    }).orElse(null); // Ürün bulunamazsa null döndür
	}


	
	
}
