package com.example.crudreview.dto.response;

import com.example.crudreview.domain.Article;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.dialect.sql.ast.SqlAstTranslatorWithOnDuplicateKeyUpdate;

import java.time.LocalDateTime;

@Getter
@Builder
public class ArticleResponse {
    private final Long id;
    private final String content;
    private final String title;
    private final String author;
    private final LocalDateTime createdAt;

    public static ArticleResponse from (Article article) {
//        method
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .author(article.getAuthor())
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .build();
    }
}