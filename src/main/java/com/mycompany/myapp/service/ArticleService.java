package com.mycompany.myapp.service;

import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.ArticleRepository;
import com.mycompany.myapp.repository.AuthorRepository;
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
    final AuthorRepository authorRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(Integer id) {
        return articleRepository.findById(id);
    }

    public Page<Article> findByAuthorId(Integer authorId, Pageable pageable) {
        return articleRepository.findByAuthorId(authorId, pageable);
    }

    public Article createPost(Integer authorId, Article article) throws Exception {
        return authorRepository.findById(authorId).map(author -> {
            article.setAuthor(author);
            return articleRepository.save(article);
        }).orElseThrow(() -> new Exception("error with: " + authorId));
    }


}
