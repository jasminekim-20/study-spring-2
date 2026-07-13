package com.example.crudreview.dto.response;

import com.example.crudreview.domain.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticleSummaryResponse {
    private final String title;
    private final String author;
    private final String content;

    public static ArticleSummaryResponse from (Article article) {
        return ArticleSummaryResponse.builder()
                .title(article.getTitle())
                .author(article.getAuthor())
                .content(article.getContent())
                .build();

    }
}
