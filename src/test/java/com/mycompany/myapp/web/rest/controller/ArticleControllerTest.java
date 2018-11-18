package com.mycompany.myapp.web.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.models.Article;
import com.mycompany.myapp.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticleController.class, secure = false)
@EnableSpringDataWebSupport
public class ArticleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArticleService articleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getArticleShouldReturnOk() throws Exception {
        Article article = new Article("Test", "Test");
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        final Page<Article> page = new PageImpl<>(articles);

        when(articleService.findAllArticlesPaginated(0, Integer.MAX_VALUE)).thenReturn(page);

        this.mvc
            .perform(get("/api/articles").accept("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0]", isA(Object.class)))
            .andExpect(jsonPath("$.content[0].title", is("Test")))
            .andExpect(jsonPath("$.content[0].content", is("Test")))
            .andDo(print());
    }

    @Test
    public void postArticleShouldReturnOk() throws Exception {
        Article article = new Article("Test", "Test");
        String content = objectMapper.writeValueAsString(article);
        this.mvc.perform(
            post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
            .andExpect(status().isOk())
            .andDo(print());
    }
}
