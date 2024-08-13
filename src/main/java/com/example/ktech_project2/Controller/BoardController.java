package com.example.ktech_project2.Controller;


import com.example.ktech_project2.Service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {
    private  final Services services;

    @GetMapping("board")
    public String board(Model model){
        model.addAttribute("boardList",services.readArticleAll());
        model.addAttribute("returnBoardType","전체 게시판");
        return "boards/board";
    }
    @GetMapping("자유게시판")
    public String freeBoard(Model model){
        model.addAttribute("returnBoardType","자유게시판");
        model.addAttribute("boardList",services.findAllByArticleType("자유게시판"));
        return "boards/board";
    }
    @GetMapping("개발게시판")
    public String developmentBoard(Model model){
        model.addAttribute("returnBoardType","개발게시판");
        model.addAttribute("boardList",services.findAllByArticleType("개발게시판"));
        return "boards/board";
    }
    @GetMapping("일상게시판")
    public String dailyBoard(Model model){
        model.addAttribute("returnBoardType","일상게시판");
        model.addAttribute("boardList",services.findAllByArticleType("일상게시판"));
        return "boards/board";
    }
    @GetMapping("사건사고게시판")
    public String incidentBoard(Model model){
        model.addAttribute("returnBoardType","사건사고 게시판");
        model.addAttribute("boardList",services.findAllByArticleType("사건사고게시판"));
        return "boards/board";
    }
}