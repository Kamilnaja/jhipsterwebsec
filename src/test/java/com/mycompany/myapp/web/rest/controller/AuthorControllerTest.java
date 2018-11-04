package com.mycompany.myapp.web.rest.controller;

import com.mycompany.myapp.NcmssecApp;
import com.mycompany.myapp.repository.ArticleRepository;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NcmssecApp.class)
public class AuthorControllerTest {
    private MockMvc mockMvc;

    @Auto
    private ArticleRepository articleRepository;

    @Test
    public void addAndReturnOneAuthor() throws Exception {
//        Author author = new Author("Test1");
//        author.setEmail("test@gmail.com");
//        author.setLastname("testowy");
//        this.mockMvc.perform(post("/api/author", author)).andExpect(status().isOk());
    }
}
