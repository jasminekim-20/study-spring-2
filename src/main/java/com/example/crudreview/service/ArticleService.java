package com.example.crudreview.service;

import com.example.crudreview.domain.Article;
import com.example.crudreview.dto.response.ArticleDetailResponse;
import com.example.crudreview.dto.response.ArticleSummaryResponse;
import com.example.crudreview.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleDetailResponse addArticle(String content, String author, String password, String title) {
        Article article = new Article(title, content, password,author);
        articleRepository.save(article);
        return ArticleDetailResponse.from(article);
    }
    @Transactional(readOnly = true)
    public ArticleDetailResponse getOneArticle(long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID의 게시글을 찾을 수 없습니다."));
        return ArticleDetailResponse.from(article);
    }
    @Transactional(readOnly = true)
    public List<ArticleSummaryResponse> getArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleSummaryResponse> articleResponses = articles.stream()
                .map(ArticleSummaryResponse::from)
                .toList();
        return articleResponses;
    }
    @Transactional
    public ArticleDetailResponse updateArticle(Long id, String title, String content, String password) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("해당 ID의 게시글을 찾을 수 없습니다."));

        article.update(title, content);
        articleRepository.save(article);
        return ArticleDetailResponse.from(article);
    }

}