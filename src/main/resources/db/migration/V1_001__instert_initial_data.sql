CREATE SCHEMA IF NOT EXISTS urun AUTHORIZATION devuser;



-- Kategoriler tablosuna veri ekleme
INSERT INTO urun.Kategoriler (ad, ust_kategori_id) VALUES 
('Elektronik', NULL),
('Bilgisayar', 1),
('Telefon', 1);

-- Urunler tablosuna veri ekleme
INSERT INTO urun.Urunler (ad, aciklama, fiyat, kategori_id, stok_miktari) VALUES 
('Laptop', 'Yüksek performanslı bir laptop.', 7500.00, 2, 15),
('Akıllı Telefon', 'Son model akıllı telefon.', 3500.00, 3, 30),
('Kulaklık', 'Kablosuz Bluetooth kulaklık.', 200.00, 1, 50);

-- Urun_Resimleri tablosuna veri ekleme
INSERT INTO urun.Urun_Resimleri (urun_id, resim_url, ana_resim) VALUES 
(1, 'https://media.istockphoto.com/id/479520746/tr/foto%C4%9Fraf/laptop-with-blank-screen-on-white.jpg?s=612x612&w=0&k=20&c=sYh67hrHs8KBSvUmUD6YpIaasEXaFD4l3_5qh--Mumc=', TRUE),
(2, 'https://media.istockphoto.com/id/1405838999/tr/foto%C4%9Fraf/smartphone-similar-to-iphone-13-with-blank-white-screen-for-infographic-global-business.jpg?s=612x612&w=0&k=20&c=IYlsnIC3rqKTmkD6bR_YP281pjE_E_1m0GPqvHt4iTk=', TRUE),
(3, 'https://media.istockphoto.com/id/1246138278/tr/foto%C4%9Fraf/beyaz-arka-planda-izole-havada-g%C3%BCm%C3%BC%C5%9F-metalik-beyaz-kablosuz-kulakl%C4%B1klar-m%C3%BCzik-cihaz%C4%B1-u%C3%A7an.jpg?s=612x612&w=0&k=20&c=Ikf9-NUzigJkSkDuQjG97Y4govXAQMW5BB2-2jHVwJo=', TRUE);

-- Urun_Etiketleri tablosuna veri ekleme
INSERT INTO urun.Urun_Etiketleri (etiket_ad) VALUES 
('Yeni Ürün'),
('Çok Satan'),
('İndirimli');

-- Urun_Etiket_Iliski tablosuna veri ekleme
INSERT INTO urun.Urun_Etiket_Iliski (urun_id, etiket_id) VALUES 
(1, 1),
(2, 2),
(3, 3);

-- Stok tablosuna veri ekleme
INSERT INTO urun.Stok (urun_id, miktar, depo_konumu) VALUES 
(1, 15, 'Depo A'),
(2, 30, 'Depo B'),
(3, 50, 'Depo C');

-- Urun_Yorumlari tablosuna veri ekleme
INSERT INTO urun.Urun_Yorumlari (urun_id, musteri_id, puan, yorum) VALUES 
(1, 101, 5, 'Harika bir ürün, tavsiye ederim!'),
(2, 102, 4, 'Genel olarak iyi, ancak pil ömrü daha uzun olabilirdi.'),
(3, 103, 3, 'Fiyatına göre iyi, ancak bazı eksiklikleri var.');

-- Setting tablosuna veri ekleme
INSERT INTO urun.setting (key, value) VALUES 
('currency', 'TRY'),
('tax_rate', '18'),
('discount_active', 'true');
