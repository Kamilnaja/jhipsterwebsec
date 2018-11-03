package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Author;
import com.mycompany.myapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    final
    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(@PathVariable("id") Integer id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }

}
