package com.mycompany.myapp.repository;

import com.mycompany.myapp.models.PageSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageSettingsRepository extends JpaRepository<PageSettings, Integer> {
}
