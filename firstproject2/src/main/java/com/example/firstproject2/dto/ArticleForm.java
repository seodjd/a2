package com.example.firstproject2.dto;


import com.example.firstproject2.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    public Article toEntity(){

        return new Article(id, title, content);
    }

}
