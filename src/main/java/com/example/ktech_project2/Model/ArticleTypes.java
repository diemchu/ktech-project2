package com.example.ktech_project2.Model;


import lombok.Getter;

@Getter
public enum ArticleTypes {
    TYPE1("자유게시판"),
    TYPE2("개발게시판"),
    TYPE3("일상게시판"),
    TYPE4("사건사고게시판");

    private final String description;

    ArticleTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
