package com.example.ktech_project2.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;
    String password;
    @ManyToOne
    @ToString.Exclude
    private  Article commentedArticleId;
}
