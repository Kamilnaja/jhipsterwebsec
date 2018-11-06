package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.models.PageSettings;
import com.mycompany.myapp.service.PageSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
        try {
            return pageSettingsService.getPageSettings();
        } catch (IndexOutOfBoundsException e) {
            return createDefaultSettings();
        }
    }

    private PageSettings createDefaultSettings() {
        PageSettings defaultSettings = new PageSettings();
        defaultSettings.setTitle("Default title");
        defaultSettings.setFooter("Default footer");
        return defaultSettings;
    }

    @PostMapping(
        value = "/pagesettings", consumes = APPLICATION_JSON_VALUE)
    public PageSettings setPageSettings(@RequestBody PageSettings pageSettings) {
        return pageSettingsService.deleteOldSettingsAndSetNew(pageSettings);
    }
}
