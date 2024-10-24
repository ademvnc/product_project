package tr.edu.ogu.ceng.product.service;

import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.product.model.Setting;
import tr.edu.ogu.ceng.product.repository.SettingRepository;

@Service
public class SettingService {

    private final SettingRepository settingRepository;

    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    public Setting getSettingById(Long id) {
        return settingRepository.findById(id).orElse(null);
    }
    
    public String getSetting(String key) {
        Setting setting = settingRepository.findByKey(key);
        if (setting != null) {
            return setting.getValue();
        }
        return null; // Eğer key yoksa null döner
    }
}
