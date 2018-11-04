package com.mycompany.myapp.repository;

import com.mycompany.myapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
