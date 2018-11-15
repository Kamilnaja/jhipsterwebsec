package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController {

    final
    UserRepository userRepository;

    final
    ArticleService articleService;

    @Autowired
    public ArticleController(UserRepository userRepository, ArticleService articleService) {
        this.userRepository = userRepository;
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/authors/{authorId}/articles")
    public Page<Article> getAllArticlesByAuthorId(@PathVariable(value = "authorId") Long authorId, Pageable pageable) {
        return articleService.findByUserId(authorId, pageable);
    }

    @PostMapping("/authors/{authorId}/articles")
    public Article createArticle(
        @PathVariable(value = "authorId") Long authorId,
        @Valid @RequestBody Article article) throws Exception {
        return articleService.createArticle(authorId, article);
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> findOne(@PathVariable("id") Integer id) {
        return articleService.findById(id);
    }

}
