package com.example.ktech_project2.Repository;


import com.example.ktech_project2.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c WHERE c.commentedArticle.id = :articleId")
    List<Comment> findAllByArticleId(@Param("articleId") Long articleId);
}
