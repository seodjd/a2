package com.example.firstproject2.controller;


import com.example.firstproject2.dto.ArticleForm;
import com.example.firstproject2.dto.CommentDto;
import com.example.firstproject2.entity.Article;
import com.example.firstproject2.repository.ArticleRepository;
import com.example.firstproject2.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j  // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired  // 스프링 부트가 미리 생성한 객체를 가져와 자동 연결
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

//        System.out.println(form.toString());
        log.info(form.toString());

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();

        // 2. Repository에게 Entity를 DB안에 저장하게 한다.

        Article saved = articleRepository.save(article);

//        System.out.println(saved);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")   // {id}는 변하는 수다.
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1. id로 데이터를 가져옴

        Article article = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);
        // 2. 가져온 data를 model에 등록
        model.addAttribute("article", article);
        model.addAttribute("commentDtos", commentDtos);


        // 3. 보여줄 page를 설정

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){

        // 1. 모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 View로 전달한다.
        model.addAttribute("articleList", articleEntityList);
        // 3. View 페이지 설정

        return "articles/index";
    }


    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        // 수정할 데이터를 가져온다.

        Article article = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", article);

        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){

        log.info(form.toString());

        // 1. DTO를 Entity로 변환한다.
        Article articleEntity = form.toEntity();

        log.info(articleEntity.toString());
        // 2. Entity를 DB로 저장
        // 2-1. DB의 기존 데이터를 가져온다.
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        // 2-2. 기존 데이터 값을 갱신한다.
        if(target != null){
            articleRepository.save(articleEntity);
        }
        // 3. 수정 결과 페이지로 Redirect 한다.
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔다.");

        // 1. 삭제 대상을 가져온다.
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2. 대상을 삭제한다.
        if(target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        }
        // 3. 결과 페이지로 Redirect 한다.
        return "redirect:/articles";
    }
}
