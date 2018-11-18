package com.mycompany.myapp.repository;

import com.mycompany.myapp.models.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findIfRepositoryReturnsArticles() {
        Article article = new Article("hello test", "test content");
        entityManager.persist(article);
        entityManager.flush();

        Page<Article> articleFound = articleRepository.findByUserId((long) 1, Pageable.unpaged());
        assertThat(articleFound.getTotalPages()).isGreaterThan(0);
    }
}
