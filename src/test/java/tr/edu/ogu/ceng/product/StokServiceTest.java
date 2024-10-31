package tr.edu.ogu.ceng.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import tr.edu.ogu.ceng.product.model.Stok;
import tr.edu.ogu.ceng.product.repository.StokRepository;
import tr.edu.ogu.ceng.product.service.StokService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

public class StokServiceTest {

    @Mock
    private StokRepository stokRepository;

    @InjectMocks
    private StokService stokService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStokById() {
        // Test verisini oluştur
        Stok stok = new Stok();
        stok.setStokId(1L);
        stok.setMiktar(100);
        stok.setDepoKonumu("Depo A");

        // Mock davranışını tanımla
        when(stokRepository.findById(1L)).thenReturn(Optional.of(stok));

        // Metodu çağır ve sonucu al
        Stok result = stokService.getStokById(1L);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(1L, result.getStokId());
        assertEquals(100, result.getMiktar());
        assertEquals("Depo A", result.getDepoKonumu());
    }

    @Test
    public void testGetAllStok() {
        // Test verilerini oluştur
        Stok stok1 = new Stok();
        stok1.setStokId(1L);
        stok1.setMiktar(100);
        stok1.setDepoKonumu("Depo A");

        Stok stok2 = new Stok();
        stok2.setStokId(2L);
        stok2.setMiktar(200);
        stok2.setDepoKonumu("Depo B");

        List<Stok> stokList = Arrays.asList(stok1, stok2);

        // Mock davranışını tanımla
        when(stokRepository.findAll()).thenReturn(stokList);

        // Metodu çağır ve sonucu al
        List<Stok> result = stokService.getAllStok();

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(stok1, result.get(0));
        assertEquals(stok2, result.get(1));
    }

    @Test
    public void testCreateStok() {
        // Test verisini oluştur
        Stok stok = new Stok();
        stok.setMiktar(100);
        stok.setDepoKonumu("Depo A");

        // Mock davranışını tanımla
        when(stokRepository.save(stok)).thenReturn(stok);

        // Metodu çağır ve sonucu al
        Stok result = stokService.createStok(stok);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(100, result.getMiktar());
        assertEquals("Depo A", result.getDepoKonumu());
    }

    @Test
    public void testUpdateStok() {
        // Test verilerini oluştur
        Stok existingStok = new Stok();
        existingStok.setStokId(1L);
        existingStok.setMiktar(100);
        existingStok.setDepoKonumu("Depo A");

        Stok updatedStok = new Stok();
        updatedStok.setMiktar(150);
        updatedStok.setDepoKonumu("Depo B");

        // Mock davranışını tanımla
        when(stokRepository.findById(1L)).thenReturn(Optional.of(existingStok));
        when(stokRepository.save(existingStok)).thenReturn(existingStok);

        // Metodu çağır ve sonucu al
        Stok result = stokService.updateStok(1L, updatedStok);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(1L, result.getStokId());
        assertEquals(150, result.getMiktar());
        assertEquals("Depo B", result.getDepoKonumu());
    }

    @Test
    public void testUpdateStok_NotFound() {
        // Mock davranışını tanımla
        when(stokRepository.findById(1L)).thenReturn(Optional.empty());

        // Metodu çağır ve sonucu al
        Stok result = stokService.updateStok(1L, new Stok());

        // Sonuçları doğrula
        assertNull(result);
    }

    @Test
    public void testDeleteStok() {
        // Metodu çağır
        stokService.deleteStok(1L);

        // Repository'nin deleteById metot çağrısını doğrula
        verify(stokRepository, times(1)).deleteById(1L);
    }
}