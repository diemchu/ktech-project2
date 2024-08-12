package com.example.ktech_project2.Controller;


import com.example.ktech_project2.Service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {
    private  final Services services;


    @RequestMapping("{articleId}/comment")
    public String create(
            Model model,
            @RequestParam("password") String password,
            @RequestParam("content") String content,
            @PathVariable("articleId") Long articleId
    ){
        services.createComment(articleId,content,password);
        model.addAttribute("article",services.findById(articleId));
        return String.format("/articles/article-view",articleId);
    }
}
