package tr.edu.ogu.ceng.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import tr.edu.ogu.ceng.product.model.UrunYorumlari;
import tr.edu.ogu.ceng.product.repository.UrunYorumlariRepository;
import tr.edu.ogu.ceng.product.service.UrunYorumlariService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

public class UrunYorumlariServiceTest {

    @Mock
    private UrunYorumlariRepository urunYorumlariRepository;

    @InjectMocks
    private UrunYorumlariService urunYorumlariService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Test verisini oluştur
        UrunYorumlari yorum = new UrunYorumlari();
        yorum.setYorumId(1L);
        yorum.setYorum("Harika ürün!");
        yorum.setPuan(5);

        // Mock davranışını tanımla
        when(urunYorumlariRepository.findById(1L)).thenReturn(Optional.of(yorum));

        // Metodu çağır ve sonucu al
        UrunYorumlari result = urunYorumlariService.findById(1L);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(1L, result.getYorumId());
        assertEquals("Harika ürün!", result.getYorum());
        assertEquals(5, result.getPuan());
    }

    @Test
    public void testFindById_NotFound() {
        // Mock davranışını tanımla
        when(urunYorumlariRepository.findById(1L)).thenReturn(Optional.empty());

        // Metodu çağır ve istisnayı yakala
        Exception exception = assertThrows(RuntimeException.class, () -> {
            urunYorumlariService.findById(1L);
        });

        // İstisna mesajını doğrula
        assertEquals("Yorum bulunamadı: 1", exception.getMessage());
    }

    @Test
    public void testFindAll() {
        // Test verilerini oluştur
        UrunYorumlari yorum1 = new UrunYorumlari();
        yorum1.setYorumId(1L);
        yorum1.setYorum("Harika ürün!");
        yorum1.setPuan(5);

        UrunYorumlari yorum2 = new UrunYorumlari();
        yorum2.setYorumId(2L);
        yorum2.setYorum("İyi ürün.");
        yorum2.setPuan(4);

        List<UrunYorumlari> yorumList = Arrays.asList(yorum1, yorum2);

        // Mock davranışını tanımla
        when(urunYorumlariRepository.findAll()).thenReturn(yorumList);

        // Metodu çağır ve sonucu al
        List<UrunYorumlari> result = urunYorumlariService.findAll();

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(yorumList, result);
    }

    @Test
    public void testSave() {
        // Test verisini oluştur
        UrunYorumlari yorum = new UrunYorumlari();
        yorum.setYorum("Mükemmel!");
        yorum.setPuan(5);

        // Mock davranışını tanımla
        when(urunYorumlariRepository.save(yorum)).thenReturn(yorum);

        // Metodu çağır ve sonucu al
        UrunYorumlari result = urunYorumlariService.save(yorum);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals("Mükemmel!", result.getYorum());
        assertEquals(5, result.getPuan());
    }

    @Test
    public void testUpdate() {
        // Mevcut ve güncellenmiş yorumları oluştur
        UrunYorumlari existingYorum = new UrunYorumlari();
        existingYorum.setYorumId(1L);
        existingYorum.setYorum("İyi ürün");
        existingYorum.setPuan(4);

        UrunYorumlari updatedYorum = new UrunYorumlari();
        updatedYorum.setYorum("Harika ürün");
        updatedYorum.setPuan(5);

        // Mock davranışını tanımla
        when(urunYorumlariRepository.findById(1L)).thenReturn(Optional.of(existingYorum));
        when(urunYorumlariRepository.save(existingYorum)).thenReturn(existingYorum);

        // Metodu çağır ve sonucu al
        UrunYorumlari result = urunYorumlariService.update(1L, updatedYorum);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(1L, result.getYorumId());
        assertEquals("Harika ürün", result.getYorum());
        assertEquals(5, result.getPuan());
    }

    @Test
    public void testDelete() {
        // Test verisini oluştur
        UrunYorumlari existingYorum = new UrunYorumlari();
        existingYorum.setYorumId(1L);

        // Mock davranışını tanımla
        when(urunYorumlariRepository.findById(1L)).thenReturn(Optional.of(existingYorum));
        doNothing().when(urunYorumlariRepository).delete(existingYorum);

        // Metodu çağır
        urunYorumlariService.delete(1L);

        // Delete metodunun çağrıldığını doğrula
        verify(urunYorumlariRepository, times(1)).delete(existingYorum);
    }
}
