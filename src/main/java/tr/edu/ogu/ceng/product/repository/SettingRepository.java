package tr.edu.ogu.ceng.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.ogu.ceng.product.model.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    // Key'e göre ayarları bulmak için custom bir metot
    Setting findByKey(String key);
    
    Optional<Setting> findById(Long id);
}