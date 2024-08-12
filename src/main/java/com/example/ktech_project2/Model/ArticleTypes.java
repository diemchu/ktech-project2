package com.example.ktech_project2.Model;


import lombok.Getter;

@Getter
public enum ArticleTypes {
    FreeBoard("자유게시판"),
    DevelopmentBoard("개발게시판"),
    DailyBoard("일상게시판"),
    IncidentBoard("사건사고게시판");


    private final String description;

    ArticleTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
