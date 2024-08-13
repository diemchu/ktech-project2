package com.example.ktech_project2.Service;


import com.example.ktech_project2.Model.Article;
import com.example.ktech_project2.Model.Comment;
import com.example.ktech_project2.Repository.ArticleRepository;
import com.example.ktech_project2.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Services {
    private final  ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    //게시판 작성 기능
    public void createArticle(String title,String content,String password,String articleType){
        Article article = new Article();
        article.setTitle(title);
        article.setPassword(password);
        article.setArticleType(articleType);
        article.setContent(content);
        articleRepository.save(article);
    }

    // 모든 게시글 가져온다
    public List<Article> readArticleAll(){
        return  articleRepository.findAllOrderByIdDesc();
    }
    //게시판별로 데이터를 가져온디
    public List<Article> findAllByArticleType(String articleType){
        return articleRepository.findAllByArticleTypeOrderByIdDesc(articleType);
    }
    //아이디로 객체를 가져온다
    public  Article findById(Long id){
        return  articleRepository.findById(id).orElseThrow();
    }
    //아이디로 article 삭제
    public  void deleteById(Long id){
        articleRepository.deleteById(id);
    }
    // update article method
    public void update(Long id ,String title,String content,String articleType){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setArticleType(articleType);
        article.setContent(content);
        articleRepository.save(article);
    }
    //create comment
    public void createComment(Long articleId,String content,String password){
        Comment comment = new Comment();
        comment.setPassword(password);
        comment.setCommentedArticle(findById(articleId));
        comment.setContent(content);
        System.out.println(comment);
        commentRepository.save(comment);
    }
    //getCommentList
    public List<Comment> getCommentList(Long articleId){
      return commentRepository.findAllByArticleId(articleId);
    }
    // delete comment by id
    public  void deleteCommentById(Long id){
        commentRepository.deleteById(id);
    }
    // get comment by id
    public  Comment  readComment(Long id){
        return commentRepository.findById(id).orElseThrow();
    }

    // find All article by tag
    public List<Article> findArticleAllByTag(String tag ){
        return  articleRepository.findAllByTag(tag);
    }

    // Search Tern by
    public List<Article> searchAllByContent(String searchTern){
        return  articleRepository.findAllByContent(searchTern);
    }

    public List<Article> searchAllByTitle(String searchTern){
        return  articleRepository.findAllByTitle(searchTern);
    }
    public  List<Article> searchAllByArticleTypeAndContent(String contentType, String searchTern){
        return articleRepository.findAllByArticleTypeAndContent(contentType,searchTern);

    }
    public  List<Article> searchAllByArticleTypeAndTitle(String  contentType, String searchTern ){
        return articleRepository.findAllByArticleTypeAndTitle(contentType,searchTern);

    }


}
