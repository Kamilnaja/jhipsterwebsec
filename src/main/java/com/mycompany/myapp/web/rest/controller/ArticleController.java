package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.domain.Article;
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
@RequestMapping("/api")
public class ArticleController {

    private final
    AuthorRepository authorRepository;

    private final
    ArticleService articleService;

    @Autowired
    public ArticleController(AuthorRepository authorRepository, ArticleService articleService) {
        this.authorRepository = authorRepository;
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/author/{authorId}/article")
    public Page<Article> getAllArticlesByAuthorId(@PathVariable(value = "authorId") Integer authorId, Pageable pageable) {
        return articleService.findByAuthorId(authorId, pageable);
    }

    @PostMapping("/author/{authorId}/article")
    public Article createPost(
            @PathVariable(value = "authorId") Integer authorId,
            @Valid @RequestBody Article article) throws Exception {
        return articleService.createPost(authorId, article);
    }

    @GetMapping("/article/{id}")
    public Optional<Article> findOne(@PathVariable("id") Integer id) {
        return articleService.findById(id);
    }
}
