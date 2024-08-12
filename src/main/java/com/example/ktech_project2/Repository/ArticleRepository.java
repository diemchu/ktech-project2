package com.example.ktech_project2.Repository;


import com.example.ktech_project2.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findAllByArticleTypeOrderByIdDesc(String articleType);

    @Query("SELECT a FROM Article a ORDER BY a.id DESC")
    List<Article> findAllOrderByIdDesc();
}
