package com.example.crudreview.controller;

import com.example.crudreview.dto.response.ArticleSummaryResponse;
import com.example.crudreview.service.ArticleService;
import com.example.crudreview.dto.request.ArticleRequest;
import com.example.crudreview.dto.response.ApiResponse;
import com.example.crudreview.dto.response.ArticleDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> addArticle(@RequestBody ArticleRequest request) {
        ArticleDetailResponse articleDetailResponse =articleService.addArticle(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201, "게시글 생성 성공", articleDetailResponse));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> getOneArticle(@PathVariable Long id) {
        ArticleDetailResponse articleDetailResponse = articleService.getOneArticle(id);

        return ResponseEntity.ok(ApiResponse.success(200, "게시글 개별 조회에 성공하였습니다.", articleDetailResponse));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<ArticleSummaryResponse>>> getArticles() {
        List<ArticleSummaryResponse> articleDetailResponses = articleService.getArticles();

        return ResponseEntity.ok(ApiResponse.success(200, "게시글 전체 조회에 성공하였습니다.", articleDetailResponses));
    }

}
