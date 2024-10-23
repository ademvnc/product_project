CREATE SCHEMA IF NOT EXISTS urun AUTHORIZATION postgres;

-- 1. Kategoriler tablosunu oluştur
CREATE TABLE urun.Kategoriler (
    kategori_id SERIAL PRIMARY KEY,
    ad VARCHAR(255) NOT NULL,
    ust_kategori_id INT REFERENCES urun.Kategoriler(kategori_id) ON DELETE SET NULL
);
-- 2. Urunler tablosunu oluştur
CREATE TABLE urun.Urunler (
    urun_id SERIAL PRIMARY KEY,
    ad VARCHAR(255) NOT NULL,
    aciklama TEXT,
    fiyat DECIMAL(10, 2) NOT NULL,
    kategori_id INT REFERENCES urun.Kategoriler(kategori_id),
    stok_miktari INT NOT NULL,
    eklenme_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    guncellenme_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Urun_Resimleri tablosunu oluştur
CREATE TABLE urun.Urun_Resimleri (
    resim_id SERIAL PRIMARY KEY,
    urun_id INT REFERENCES urun.Urunler(urun_id) ON DELETE CASCADE,
    resim_url TEXT NOT NULL,
    ana_resim BOOLEAN DEFAULT FALSE
);

-- 4. Urun_Etiketleri tablosunu oluştur
CREATE TABLE urun.Urun_Etiketleri (
    etiket_id SERIAL PRIMARY KEY,
    etiket_ad VARCHAR(255) NOT NULL
);

-- 5. Urun_Etiket_Iliski tablosunu oluştur
CREATE TABLE urun.Urun_Etiket_Iliski (
    urun_id INT REFERENCES urun.Urunler(urun_id) ON DELETE CASCADE,
    etiket_id INT REFERENCES urun.Urun_Etiketleri(etiket_id) ON DELETE CASCADE,
    PRIMARY KEY (urun_id, etiket_id)
);

-- 6. Stok tablosunu oluştur
CREATE TABLE urun.Stok (
    stok_id SERIAL PRIMARY KEY,
    urun_id INT REFERENCES urun.Urunler(urun_id) ON DELETE CASCADE,
    miktar INT NOT NULL,
    depo_konumu VARCHAR(255)
);

-- 7. Urun_Yorumlari tablosunu oluştur
CREATE TABLE urun.Urun_Yorumlari (
    yorum_id SERIAL PRIMARY KEY,
    urun_id INT REFERENCES urun.Urunler(urun_id) ON DELETE CASCADE,
    musteri_id INT, -- Eğer müşteri tablosu varsa bunu REFERENCES ile bağlayabilirsin
    puan INT CHECK (puan >= 1 AND puan <= 5),
    yorum TEXT,
    yorum_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
