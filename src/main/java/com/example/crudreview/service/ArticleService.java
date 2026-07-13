package com.example.crudreview.service;

import com.example.crudreview.domain.Article;
import com.example.crudreview.dto.response.ArticleResponse;
import com.example.crudreview.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleResponse addArticle(String content, String author, String password, String title) {
        Article article = new Article(title, content, password,author);
        articleRepository.save(article);
        return ArticleResponse.from(article);
    }

}