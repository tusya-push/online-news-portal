package com.example.onlinenewsportal.controller;

import com.example.onlinenewsportal.entity.Article;
import com.example.onlinenewsportal.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final ArticleService articleService;

    public HomePageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("articles", articleService.getAllArticlesDesc());
        return "homepage";
    }

}
