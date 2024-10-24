package tr.edu.ogu.ceng.product.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import tr.edu.ogu.ceng.product.model.Setting;
import tr.edu.ogu.ceng.product.service.SettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/setting")
public class SettingController {

    private final SettingService settingService; 

    @GetMapping("/{id}")
    public Setting getSetting(@PathVariable Long id) {
        return settingService.getSettingById(id); // Doğru şekilde SettingService'i kullanarak Setting nesnesini döndürün
    }

    // Getter metodu
    public SettingService getSettingService() {
        return settingService;
    }
    
    @GetMapping("/getSetting")
    public String getSetting(@RequestParam String key) {
        return settingService.getSetting(key);
    }
    

   
}
