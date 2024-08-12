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
       createModel(model);
        services.createArticle(title, content, password, articleType );
        return "boards/board";
    }

    @GetMapping("{id}")
    public String articleView(@PathVariable("id") Long id,Model model){
        Article article = services.findById(id);
        model.addAttribute("article",article);
        model.addAttribute("commentList", services.getCommentList(id));
        return "articles/article-view";
    }

    @PostMapping("{id}/delete")
    public  String delete(
            @PathVariable("id") Long id,
            @RequestParam("password") String password,
            Model model
    ){
        Article crrentArticle = services.findById(id);
        if(crrentArticle !=null && crrentArticle.getPassword().equals(password)){
            services.deleteById(id);
        }
        createModel(model);
        return "boards/board";
    }

    @RequestMapping("{id}/update")
    public String update(
            Model model,
            @PathVariable("id") Long id
    ){
        model.addAttribute("article",services.findById(id));
        return "articles/update-view";
    }

    @PostMapping("{id}/update")
    public String update(
            Model model,
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password,
            @RequestParam("articleType") String articleType
    ){
        Article currentArticle = services.findById(id);

        if( currentArticle !=null && currentArticle.getPassword().equals(password)){
            services.update(id,title,content,articleType);
        }
        createModel(model);
        return "boards/board";
    }



    public void createModel(Model model){
        model.addAttribute("boardList",services.readArticleAll());
        model.addAttribute("returnBoardType","전체 게시판");
    }

}
