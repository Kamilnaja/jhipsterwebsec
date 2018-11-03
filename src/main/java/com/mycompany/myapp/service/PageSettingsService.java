package com.mycompany.myapp.service;

import com.mycompany.myapp.models.PageSettings;
import com.mycompany.myapp.repository.PageSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageSettingsService {

    private final
    PageSettingsRepository pageSettingsRepository;

    @Autowired
    public PageSettingsService(PageSettingsRepository pageSettingsRepository) {
        this.pageSettingsRepository = pageSettingsRepository;
    }

    public PageSettings getPageSettings() {
        List<PageSettings> settings = pageSettingsRepository.findAll();
        return settings.get(0);
    }

    public PageSettings deleteOldSettingsAndSetNew(PageSettings pageSettings) {
        this.pageSettingsRepository.deleteAll();
        return pageSettingsRepository.save(pageSettings);
    }
}
