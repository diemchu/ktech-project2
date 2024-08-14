package com.example.ktech_project2.Repository;


import com.example.ktech_project2.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByArticleTypeOrderByIdDesc(String articleType);

    @Query("SELECT a FROM Article a ORDER BY a.id DESC")
    List<Article> findAllOrderByIdDesc();

    @Query("SELECT a FROM Article a WHERE a.content LIKE %:tag%")
    List<Article> findAllByTag(@Param("tag") String tag);
 
    @Query("SELECT a FROM Article a WHERE a.content LIKE %:searchTern%")
    List<Article> findAllByContent(String searchTern);

    @Query("SELECT a FROM Article a WHERE a.title LIKE %:searchTern%")
    List<Article> findAllByTitle(String searchTern);

    @Query("""
            select a from Article a where a.articleType = :articleType
            and a.content = %:searchTern%
            """)
    List<Article> findAllByArticleTypeAndContent
            (@Param("articleType") String articleType, @Param("searchTern") String searchTern);

    @Query("""
            select a from Article a where a.articleType = :articleType
            and a.title = %:searchTern%
            """)
    List<Article> findAllByArticleTypeAndTitle(
            @Param("articleType") String articleType,
            @Param("searchTern") String searchTern);

}
