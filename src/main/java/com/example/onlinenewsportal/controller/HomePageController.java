package com.example.onlinenewsportal.controller;

import com.example.onlinenewsportal.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    private final ArticleService articleService;

    public HomePageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String getHomePage(@RequestParam(value = "category", required = false) String category, Model model) {
        model.addAttribute("articles", articleService.getAllArticles(category));
        return "homepage";
    }

}
