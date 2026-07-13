package com.example.crudreview.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {
    private String title;
    private String content;
    private String author;
    private String password;
}
