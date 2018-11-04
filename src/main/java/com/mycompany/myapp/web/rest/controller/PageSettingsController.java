package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.models.PageSettings;
import com.mycompany.myapp.service.PageSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PageSettingsController {
    private final
    PageSettingsService pageSettingsService;

    @Autowired
    public PageSettingsController(PageSettingsService pageSettingsService) {
        this.pageSettingsService = pageSettingsService;
    }

    @GetMapping("/pagesettings")
    public PageSettings getFirstSettings() {
        return pageSettingsService.getPageSettings();
    }

    @PostMapping("/pagesettings")
    public PageSettings setPageSettings(@Valid PageSettings pageSettings) {
        return pageSettingsService.deleteOldSettingsAndSetNew(pageSettings);
    }
}
