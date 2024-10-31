package tr.edu.ogu.ceng.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ogu.ceng.product.model.Urunler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Urunler2Test {

    private Urunler urun;

    @BeforeEach
    public void setUp() {
        urun = new Urunler();
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
    
    @Test
    void testSetAdAndGetAd() {
        String expected = "Yeni Ürün";
        urun.setAd(expected);
        assertEquals(expected, urun.getAd());
    }
    
    @Test
    void testSetFiyatAndGetFiyat() {
        BigDecimal expected = new BigDecimal("150.00");
        urun.setFiyat(expected);
        assertEquals(expected, urun.getFiyat());
    }

    @Test
    void testSetStokMiktariAndGetStokMiktari() {
        int expected = 200;
        urun.setStokMiktari(expected);
        assertEquals(expected, urun.getStokMiktari());
    }
    
    @Test
    void testSetEklenmeTarihiAndGetEklenmeTarihi() {
        LocalDateTime expected = LocalDateTime.now();
        urun.setEklenmeTarihi(expected);
        assertEquals(expected, urun.getEklenmeTarihi());
    }
}
