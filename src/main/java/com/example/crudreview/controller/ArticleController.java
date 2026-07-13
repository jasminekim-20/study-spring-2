package com.example.crudreview.controller;

import com.example.crudreview.service.ArticleService;
import com.example.crudreview.domain.Article;
import com.example.crudreview.dto.request.ArticleRequest;
import com.example.crudreview.dto.response.ApiResponse;
import com.example.crudreview.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ArticleResponse>> addArticle(@RequestBody ArticleRequest request) {
        ArticleResponse articleResponse=articleService.addArticle(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201, "게시글 생성 성공", articleResponse));
    }
}
