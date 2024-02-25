package com.example.springbootBoard.service;

import com.example.springbootBoard.dto.AddArticleRequest;
import com.example.springbootBoard.entity.Article;
import com.example.springbootBoard.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    @Comment("블로그 글 작성")
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
