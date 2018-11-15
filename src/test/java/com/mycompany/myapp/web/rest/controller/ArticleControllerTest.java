package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.repository.ArticleRepository;
import com.mycompany.myapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserRepository userRepository;
    private MockMvc mockMvc;

    @Test
    public void endpointShouldReturnOk() throws Exception {
        Article article = new Article();
        User autor = new User();
        autor.setEmail("kamil@.com");
        autor.setFirstName("Kamil");
        autor.setId((long) 10);
        article.setUser(autor);
        article.setTitle("HEllo");
        article.setContent("hello world");

        given(this.articleRepository.save(article));
        this.mockMvc.perform(get("api/article")).andExpect(status().isOk());
        mockMvc
            .perform(get("/api/article")).andExpect(status().isOk());
    }
}
