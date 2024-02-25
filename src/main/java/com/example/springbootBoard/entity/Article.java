package com.example.springbootBoard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 지정
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
public class Article {

    @Id // id 필드 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name="title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Builder // 빌더 패턴 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
