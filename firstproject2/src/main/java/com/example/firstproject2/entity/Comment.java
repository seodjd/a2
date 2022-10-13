package com.example.firstproject2.entity;


import com.example.firstproject2.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // 해당 댓글 엔티티 여러 개가, 하나의 Article에 연관된다.
    @JoinColumn(name = "article_id")
    private Article article;    // 댓글의 부모 게시글

    @Column
    private String nickname;

    @Column
    private String body;


    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 발생
        if(dto.getId() != null){
            throw new IllegalArgumentException("댓글 생성 실패");
        }
        if(dto.getArticleId() != article.getId()){
            throw new IllegalArgumentException("댓글 생성 실패");
        }
        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );

    }

    public void patch(CommentDto dto) {
        // 예외 발생
            if(this.id != dto.getId()){
                throw new IllegalArgumentException("댓글 수정 실패");
            }
        // 객체를 갱신
        if(dto.getNickname() != null){
            this.nickname = dto.getNickname();
        }
        if(dto.getBody() != null){
            this.body = dto.getBody();
        }
    }
}
