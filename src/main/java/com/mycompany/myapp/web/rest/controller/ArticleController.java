package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public Page<Article> getAllArticles(
        @RequestParam("page") Integer page,
        @RequestParam("size") Integer size) {
        return articleService.findAllArticlesPaginated(page, size);
    }

    @GetMapping("/authors/{authorId}/articles")
    public Page<Article> getAllArticlesByAuthorId(@PathVariable(value = "authorId") Long authorId, Pageable pageable) {
        return articleService.findByUserId(authorId, pageable);
    }

    @PostMapping("/articles")
    public Article createArticle(
        @Valid @RequestBody Article article) throws Exception {
        return articleService.createArticle(article);
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> findOne(@PathVariable("id") Integer id) {
        return articleService.findById(id);
    }

}
