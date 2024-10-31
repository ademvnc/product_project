package tr.edu.ogu.ceng.product;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tr.edu.ogu.ceng.product.controller.UrunlerController;
import tr.edu.ogu.ceng.product.model.Urunler;
import tr.edu.ogu.ceng.product.repository.UrunlerRepository;
import tr.edu.ogu.ceng.product.service.UrunlerService;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class Urunler_woDockerTest {

    @Mock
    private UrunlerRepository urunlerRepository;

    @InjectMocks
    private UrunlerService urunlerService;

    @InjectMocks
    private UrunlerController urunlerController;

    @Test
    void testFindAllUrunler() {
        Urunler urun1 = new Urunler(1L, "Urun1", 10.0);
        Urunler urun2 = new Urunler(2L, "Urun2", 15.0);
        Mockito.when(urunlerRepository.findAll()).thenReturn(List.of(urun1, urun2));

        List<Urunler> urunlerList = urunlerService.getAllUrunler();

        assertEquals(2, urunlerList.size());
        assertEquals("Urun1", urunlerList.get(0).getAd());
    }

    
    @Test
    void testAddUrun() {
        Urunler urun = new Urunler(1L, "Yeni Urun", 20.0);
        Mockito.when(urunlerRepository.save(urun)).thenReturn(urun);

        Urunler createdUrun = urunlerService.addUrun(urun);

        assertNotNull(createdUrun);
        assertEquals("Yeni Urun", createdUrun.getAd());
    }

    @Test
    void testFindUrunById() {
        Urunler urun = new Urunler(1L, "Urun1", 10.0);
        Mockito.when(urunlerRepository.findById(1L)).thenReturn(Optional.of(urun));

        Urunler foundUrun = urunlerService.getUrunById(1L);

        assertNotNull(foundUrun);
        assertEquals("Urun1", foundUrun.getAd());
    }

    

    @Test
    void testDeleteUrun() {
        Urunler urun = new Urunler(1L, "Silinecek Urun", 30.0);
        Mockito.when(urunlerRepository.existsById(1L)).thenReturn(true);
        Mockito.doNothing().when(urunlerRepository).deleteById(1L);

        boolean isDeleted = urunlerService.deleteUrun(1L);

        assertTrue(isDeleted);
    }
    
    @Test
    void testUpdateUrun() {
        Urunler existingUrun = new Urunler(1L, "Eski Urun", 25.0);
        Urunler updatedUrun = new Urunler(1L, "Guncellenmis Urun", 30.0);

        Mockito.when(urunlerRepository.findById(1L)).thenReturn(Optional.of(existingUrun));
        Mockito.when(urunlerRepository.save(Mockito.any(Urunler.class))).thenReturn(updatedUrun);

        Urunler result = urunlerService.updateUrun(1L, updatedUrun);

        assertNotNull(result);
        assertEquals("Guncellenmis Urun", result.getAd());
    }

}
