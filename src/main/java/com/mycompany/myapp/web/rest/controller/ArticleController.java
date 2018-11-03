package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.AuthorRepository;
import com.mycompany.myapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    final
    AuthorRepository authorRepository;

    final
    ArticleService articleService;

    @Autowired
    public ArticleController(AuthorRepository authorRepository, ArticleService articleService) {
        this.authorRepository = authorRepository;
        this.articleService = articleService;
    }

    @GetMapping("/api/post")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/api/author/{authorId}/post")
    public Page<Article> getAllArticlesByAuthorId(@PathVariable(value = "authorId") Integer authorId, Pageable pageable) {
        return articleService.findByAuthorId(authorId, pageable);
    }

    @PostMapping("/api/author/{authorId}/post")
    public Article createPost(
            @PathVariable(value = "authorId") Integer authorId,
            @Valid @RequestBody Article article) throws Exception {
        return articleService.createPost(authorId, article);
    }

    @GetMapping("/api/post/{id}")
    public Optional<Article> findOne(@PathVariable("id") Integer id) {
        return articleService.findById(id);
    }
}
