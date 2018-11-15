package com.mycompany.myapp.service;

import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    final
    ArticleRepository articleRepository;

    final UserService userService;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, UserService authorRepository) {
        this.articleRepository = articleRepository;
        this.userService = authorRepository;
    }

    public ArticleRepository getArticleRepository() {
        return articleRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(Integer id) {
        return articleRepository.findById(id);
    }

    public Page<Article> findByUserId(Long userId, Pageable pageable) {
        return articleRepository.findByUserId(userId, pageable);
    }

    public Article createArticle(Long userId, Article article) throws Exception {
        return userService.getUserWithAuthorities(userId).map(user -> {
            article.setUser(user);
            return articleRepository.save(article);
        }).orElseThrow(() -> new Exception("error with: " + userId));
    }
}
