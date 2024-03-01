package com.example.springbootBoard.controller;

import com.example.springbootBoard.dto.AddArticleRequest;
import com.example.springbootBoard.dto.ArticleResponse;
import com.example.springbootBoard.dto.UpdateArticleRequest;
import com.example.springbootBoard.entity.Article;
import com.example.springbootBoard.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP respoonse Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RequestMapping("/api/articles")
public class BlogAPiController {

    private final BlogService blogService;

    @PostMapping
    @Comment("글 작성")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    // test
    @GetMapping
    @Comment("전체 조회")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/{id}")
    @Comment("삭제")
    public ResponseEntity<Void> deleteArticle(@PathVariable(name = "id") long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/{id}")
    @Comment("수정")
    public ResponseEntity<Article> updateArticle(@PathVariable(name = "id") long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }
}
