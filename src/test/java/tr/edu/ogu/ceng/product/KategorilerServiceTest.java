package tr.edu.ogu.ceng.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tr.edu.ogu.ceng.product.model.Kategoriler;
import tr.edu.ogu.ceng.product.repository.KategorilerRepository;
import tr.edu.ogu.ceng.product.service.KategorilerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class KategorilerServiceTest {

    @Mock
    private KategorilerRepository kategorilerRepository;

    @InjectMocks
    private KategorilerService kategorilerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetKategoriById() {
        // Test verisini oluştur
        Kategoriler kategori = new Kategoriler();
        kategori.setkategoriId(1L);
        kategori.setName("Elektronik");
        kategori.setustKategoriId(null);

        // Mock davranışını tanımla
        when(kategorilerRepository.findById(1L)).thenReturn(Optional.of(kategori));

        // Metodu çağır ve sonucu al
        Kategoriler result = kategorilerService.getKategoriById(1L);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(1L, result.getkategoriId());
        assertEquals("Elektronik", result.getName());
        assertNull(result.getustKategoriId());
    }

    @Test
    public void testGetKategorilerByUstKategoriId() {
        // Test verilerini oluştur
        Kategoriler kategori1 = new Kategoriler();
        kategori1.setkategoriId(2L);
        kategori1.setName("Telefon");
        kategori1.setustKategoriId(1L);

        Kategoriler kategori2 = new Kategoriler();
        kategori2.setkategoriId(3L);
        kategori2.setName("Tablet");
        kategori2.setustKategoriId(1L);

        List<Kategoriler> kategoriList = Arrays.asList(kategori1, kategori2);

        // Mock davranışını tanımla
        when(kategorilerRepository.findByUstKategoriId(1L)).thenReturn(kategoriList);

        // Metodu çağır ve sonucu al
        List<Kategoriler> result = kategorilerService.getKategorilerByUstKategoriId(1L);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Telefon", result.get(0).getName());
        assertEquals("Tablet", result.get(1).getName());
    }

    @Test
    public void testCreateKategori() {
        // Test verisini oluştur
        Kategoriler kategori = new Kategoriler();
        kategori.setName("Yeni Kategori");
        kategori.setustKategoriId(null);

        // Mock davranışını tanımla
        when(kategorilerRepository.save(kategori)).thenReturn(kategori);

        // Metodu çağır ve sonucu al
        Kategoriler result = kategorilerService.createKategori(kategori);

        // Sonuçları doğrula
        assertNotNull(result);
        assertEquals("Yeni Kategori", result.getName());
        assertNull(result.getustKategoriId());
    }
}
