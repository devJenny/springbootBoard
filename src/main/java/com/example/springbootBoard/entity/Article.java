package com.example.springbootBoard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @CreatedDate
    @Column(name="created_at")
    @Comment("엔티티 생성 시간")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    @Comment("엔티티 수정 시간")
    private LocalDateTime updatedAt;
}
