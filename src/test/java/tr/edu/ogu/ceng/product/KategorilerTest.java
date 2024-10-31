package tr.edu.ogu.ceng.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import tr.edu.ogu.ceng.product.model.Kategoriler;

public class KategorilerTest {

    @Test
    public void testGettersAndSetters() {
        Kategoriler kategori = new Kategoriler();

        Long expectedKategoriId = 1L;
        String expectedAd = "Elektronik";
        Long expectedUstKategoriId = null;

        kategori.setkategoriId(expectedKategoriId);
        kategori.setName(expectedAd);
        kategori.setustKategoriId(expectedUstKategoriId);

        assertEquals(expectedKategoriId, kategori.getkategoriId());
        assertEquals(expectedAd, kategori.getName());
        assertEquals(expectedUstKategoriId, kategori.getustKategoriId());
    }
}
