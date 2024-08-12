package com.example.ktech_project2.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String title;
    private  String password;
    private String content;
    private  String  articleType;

    @OneToMany(mappedBy = "commentedArticleId")
    @ToString.Exclude
    private List<Comment> commentList;
}