package com.example.onlinenewsportal.controller;

import com.example.onlinenewsportal.entity.Article;
import com.example.onlinenewsportal.exception.InputFileHandlingException;
import com.example.onlinenewsportal.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.onlinenewsportal.utils.FileUtils.getArticleFromContent;
import static com.example.onlinenewsportal.utils.FileUtils.getContentFromFile;

@Controller
public class LoadingController {

    private final ArticleService articleService;

    public LoadingController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/loading")
    public String getLoadingPage() {
        return "loading";
    }

    @PostMapping("/loading")
    public String loadFile(@RequestParam("file") MultipartFile file, Model model) {
        String message = articleService.loadNewArticle(file);
        model.addAttribute("message", message);
        return "loading";
    }

}
