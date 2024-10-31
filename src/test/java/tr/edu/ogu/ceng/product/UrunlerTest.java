package tr.edu.ogu.ceng.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import tr.edu.ogu.ceng.product.model.Urunler;
import tr.edu.ogu.ceng.product.service.UrunlerService;
import tr.edu.ogu.ceng.product.repository.UrunlerRepository;
import tr.edu.ogu.ceng.product.model.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Testcontainers
public class UrunlerTest {
	
	private Urunler urun;

    @BeforeEach
    public void setUp() {
        urun = new Urunler();
    }

    // PostgreSQL Konteyneri
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14")
            .withDatabaseName("ilerijava")
            .withUsername("devuser")
            .withPassword("devpassword");

    // Redis Konteyneri
    private static final GenericContainer<?> redisContainer = new GenericContainer<>("redis:6")
            .withExposedPorts(6379);

    // PostgreSQL ve Redis konteynerlerini başlatma
    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        postgreSQLContainer.start();
        redisContainer.start();

        // PostgreSQL bağlantı bilgilerini ayarla
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        
        // Redis bağlantı bilgilerini ayarla
        registry.add("spring.redis.host", redisContainer::getHost);
        registry.add("spring.redis.port", () -> redisContainer.getMappedPort(6379));
    }

    @Autowired
    private UrunlerService urunlerService;

    @MockBean
    private UrunlerRepository urunlerRepository;

    @Test
    void testFindAllUrunler() {
        Urunler urun1 = new Urunler(1L, "Urun1", 10.0);
        Urunler urun2 = new Urunler(2L, "Urun2", 15.0);
        when(urunlerRepository.findAll()).thenReturn(List.of(urun1, urun2));

        List<Urunler> urunlerList = urunlerService.getAllUrunler();

        assertEquals(2, urunlerList.size());
        assertEquals("Urun1", urunlerList.get(0).getAd());
    }

    @Test
    void testAddUrun() {
        Urunler urun = new Urunler(1L, "Yeni Urun", 20.0);
        when(urunlerRepository.save(urun)).thenReturn(urun);

        Urunler createdUrun = urunlerService.addUrun(urun);

        assertNotNull(createdUrun);
        assertEquals("Yeni Urun", createdUrun.getAd());
    }

    @Test
    void testFindUrunById() {
        Urunler urun = new Urunler(1L, "Urun1", 10.0);
        when(urunlerRepository.findById(1L)).thenReturn(Optional.of(urun));

        Urunler foundUrun = urunlerService.getUrunById(1L);

        assertNotNull(foundUrun);
        assertEquals("Urun1", foundUrun.getAd());
    }

    @Test
    void testDeleteUrun() {
        when(urunlerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(urunlerRepository).deleteById(1L);

        boolean isDeleted = urunlerService.deleteUrun(1L);

        assertTrue(isDeleted);
    }

    @Test
    void testUpdateUrun() {
        Urunler existingUrun = new Urunler(1L, "Eski Urun", 25.0);
        Urunler updatedUrun = new Urunler(1L, "Guncellenmis Urun", 30.0);

        when(urunlerRepository.findById(1L)).thenReturn(Optional.of(existingUrun));
        when(urunlerRepository.save(any(Urunler.class))).thenReturn(updatedUrun);

        Urunler result = urunlerService.updateUrun(1L, updatedUrun);

        assertNotNull(result);
        assertEquals("Guncellenmis Urun", result.getAd());
    }
    
    @Test
    public void testGettersAndSetters() {
        // Test verilerini ayarlama
        Long expectedId = 1L;
        String expectedAd = "Test Ürünü";
        String expectedAciklama = "Bu bir test ürünüdür.";
        BigDecimal expectedFiyat = BigDecimal.valueOf(99.99);
        int expectedStokMiktari = 100;
        LocalDateTime expectedEklenmeTarihi = LocalDateTime.now();
        LocalDateTime expectedGuncellenmeTarihi = LocalDateTime.now();

        // Setter metodlarını çağırma
        urun.setUrunId(expectedId);
        urun.setAd(expectedAd);
        urun.setAciklama(expectedAciklama);
        urun.setFiyat(expectedFiyat);
        urun.setStokMiktari(expectedStokMiktari);
        urun.setEklenmeTarihi(expectedEklenmeTarihi);
        urun.setGuncellenmeTarihi(expectedGuncellenmeTarihi);

        // Getter metodları ile doğrulama
        assertEquals(expectedId, urun.getUrunId());
        assertEquals(expectedAd, urun.getAd());
        assertEquals(expectedAciklama, urun.getAciklama());
        assertEquals(expectedFiyat, urun.getFiyat());
        assertEquals(expectedStokMiktari, urun.getStokMiktari());
        assertEquals(expectedEklenmeTarihi, urun.getEklenmeTarihi());
        assertEquals(expectedGuncellenmeTarihi, urun.getGuncellenmeTarihi());
    }

    @Test
    public void testFiyatNegativeValue() {
        // Negatif fiyat testi
        assertThrows(IllegalArgumentException.class, () -> {
            urun.setFiyat(BigDecimal.valueOf(-10.00)); // Negatif fiyat atanamaz
        });
    }

    // Diğer test senaryolarını ekleyebilirsiniz
}


