CREATE SCHEMA IF NOT EXISTS urun AUTHORIZATION postgres;


CREATE TABLE urun.setting (
    id SERIAL PRIMARY KEY,
    key VARCHAR(255) UNIQUE NOT NULL,
    value VARCHAR(255) NOT NULL
);

INSERT INTO urun.setting (id, key, value) VALUES (1, 'name', 'product');

-- Kategoriler tablosuna test verileri ekle
INSERT INTO urun.kategoriler (kategori_id, ad, ust_kategori_id) VALUES 
(1, 'Elektronik', NULL);

-- Urunler tablosuna test verileri ekle
INSERT INTO urun.urunler (ad, aciklama, fiyat, kategori_id, stok_miktari) VALUES 
('Laptop', 'Yüksek performanslı bir laptop.', 3000.00, 1, 10);

INSERT INTO urun.urun_resimleri (urun_id, resim_url, ana_resim)
VALUES (1, 'https://example.com/resim1.jpg', TRUE);

INSERT INTO urun.stok (urun_id, miktar, depo_konumu) 
VALUES (1, 50, 'Depo A');

INSERT INTO urun.urun_yorumlari (urun_id, musteri_id, puan, yorum, yorum_tarihi)
VALUES (1, 123, 5, 'Great product! Highly recommend.', CURRENT_TIMESTAMP);

INSERT INTO urun.urun_etiketleri (etiket_ad) VALUES ('YourLabelName');



