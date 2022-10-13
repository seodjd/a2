package com.example.firstproject2.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 해당 클래스로 테이블을 만든다.
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성한다.
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public void patch(Article article){
        if(article.title != null){
            this.title = article.title;
        }
        if(article.content != null){
            this.content = article.content;
        }
    }

}
