package tr.edu.ogu.ceng.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// Diğer importlar

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import tr.edu.ogu.ceng.product.controller.KategorilerController;
import tr.edu.ogu.ceng.product.model.Kategoriler;
import tr.edu.ogu.ceng.product.service.KategorilerService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(KategorilerController.class)
public class KategorilerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KategorilerService kategorilerService;

    @Test
    public void testGetKategori() throws Exception {
        // Test verisini oluştur
        Kategoriler kategori = new Kategoriler();
        kategori.setkategoriId(1L);
        kategori.setName("Elektronik");
        kategori.setustKategoriId(null);

        // Mock davranışını tanımla
        when(kategorilerService.getKategoriById(1L)).thenReturn(kategori);

        // HTTP GET isteğini simüle et ve sonucu doğrula
        mockMvc.perform(get("/api/v1/kategoriler/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.kategoriId").value(1))
                .andExpect(jsonPath("$.name").value("Elektronik"))
                .andExpect(jsonPath("$.ustKategoriId").doesNotExist());
    }

    @Test
    public void testGetByUstKategori() throws Exception {
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
        when(kategorilerService.getKategorilerByUstKategoriId(1L)).thenReturn(kategoriList);

        // HTTP GET isteğini simüle et ve sonucu doğrula
        mockMvc.perform(get("/api/v1/kategoriler/getByUstKategori")
                .param("ustKategoriId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Telefon"))
                .andExpect(jsonPath("$[1].name").value("Tablet"));
    }
}
