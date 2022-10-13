package com.example.firstproject2.repository;

import com.example.firstproject2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
                                                        // 관리 대상 Entity, 대표 값(@Id)을 타입
}
