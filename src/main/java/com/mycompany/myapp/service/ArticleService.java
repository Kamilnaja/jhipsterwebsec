package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final UserService userService;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, UserService authorRepository) {
        this.articleRepository = articleRepository;
        this.userService = authorRepository;
    }

    @Transactional(readOnly = true)
    public Page<Article> findAllArticlesPaginated(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Article> findById(Integer id) {
        return articleRepository.findById(id);
    }

    public Page<Article> findByUserId(Long userId, Pageable pageable) {
        return articleRepository.findByUserId(userId, pageable);
    }

    public Article createArticle(Article article) throws Exception {
        Optional<User> userId = userService.getCurrentUserId(); // co zwraca ta metoda?
        return userService.getCurrentUserId().map(user -> {
            article.setUser(user);
            return articleRepository.save(article);
        }).orElseThrow(() -> new Exception("error with: creating article" + userId));
    }
}
