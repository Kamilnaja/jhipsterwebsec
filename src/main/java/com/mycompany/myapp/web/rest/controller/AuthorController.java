package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.domain.Author;
import com.mycompany.myapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public List<Author> getAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/author/{id}")
    public Optional<Author> findAuthorById(@PathVariable("id") Integer id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping("/author")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorService.createAuthor(author);
    }
}
