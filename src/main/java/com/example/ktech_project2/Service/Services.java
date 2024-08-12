package com.example.ktech_project2.Service;


import com.example.ktech_project2.Model.Article;
import com.example.ktech_project2.Repository.ArticleRepository;
import com.example.ktech_project2.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Services {
    private final  ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public void createArticle(String title,String content,String password,String articleType){
        Article article = new Article();
        article.setTitle(title);
        article.setPassword(password);
        article.setArticleType(articleType);
        article.setContent(content);
        articleRepository.save(article);
    }
}
