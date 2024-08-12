package com.example.ktech_project2.Controller;


import com.example.ktech_project2.Model.Article;
import com.example.ktech_project2.Service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {
    private final  Services services;



    @GetMapping("new-article")
    public String create() {
        return "articles/new-article";
    }

    @PostMapping("create")
    public String create(@RequestParam("title") String title,
                         @RequestParam("content") String content,
                         @RequestParam("password") String password,
                         @RequestParam("articleType") String articleType,
                         Model model

    ) {
        model.addAttribute("boardList",services.readArticleAll());
        model.addAttribute("returnBoardType","전체 게시판");
        services.createArticle(title, content, password, articleType );
        return "boards/board";
    }

    @GetMapping("{id}")
    public String articleView(@PathVariable("id") Long id,Model model){
        Article article = services.findById(id);
        model.addAttribute("article",article);
        return "articles/article-view";
    }

}
