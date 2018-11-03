package com.mycompany.myapp.service;

import com.mycompany.myapp.models.PageSettings;
import com.mycompany.myapp.repository.PageSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageSettingsService {

    private final
    PageSettingsRepository pageSettingsRepository;

    @Autowired
    public PageSettingsService(PageSettingsRepository pageSettingsRepository) {
        this.pageSettingsRepository = pageSettingsRepository;
    }

    public List<PageSettings> getPageSettings() {
        return pageSettingsRepository.findAll();
    }

    public PageSettings setPageSettings(PageSettings pageSettings) {
        return pageSettingsRepository.save(pageSettings);
    }


    public Optional<PageSettings> getFirstSettings() {
        return pageSettingsRepository.findById(1);
    }
}
