package com.example.ktech_project2.Controller;


import com.example.ktech_project2.Model.Comment;
import com.example.ktech_project2.Service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("commentList", services.getCommentList(articleId));
        return  "/articles/article-view";
    }

    @PostMapping("{articleId}/{id}/delete")
    public String delete(Model model,
                         @RequestParam("password") String password,
                         @PathVariable("id") Long id,
                         @PathVariable("articleId") Long articleId
                         ){

        Comment comment = services.readComment(id);
        if(comment!=null && comment.getPassword().equals(password)){
            services.deleteCommentById(id);
        }
        model.addAttribute("article",services.findById(articleId));
        model.addAttribute("commentList", services.getCommentList(articleId));
        return  "/articles/article-view";
    }


}
