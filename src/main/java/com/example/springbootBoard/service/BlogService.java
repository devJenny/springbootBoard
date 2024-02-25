package com.example.springbootBoard.service;

import com.example.springbootBoard.dto.AddArticleRequest;
import com.example.springbootBoard.dto.UpdateArticleRequest;
import com.example.springbootBoard.entity.Article;
import com.example.springbootBoard.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    @Comment("글 작성")
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    @Comment("전체 조회")
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    @Comment("단건 조회")
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Comment("삭제")
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional // 트랜잭션 메서드
    @Comment("수정")
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
