package com.mycompany.myapp.repository;

import com.mycompany.myapp.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findByUserId(Long userId, Pageable pageable);
}
