package com.example.onlinenewsportal.service;

import com.example.onlinenewsportal.entity.Article;
import com.example.onlinenewsportal.exception.InputFileHandlingException;
import com.example.onlinenewsportal.repository.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.onlinenewsportal.utils.FileUtils.getArticleFromContent;
import static com.example.onlinenewsportal.utils.FileUtils.getContentFromFile;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<Article> getAllArticlesDesc() {
        return articleRepository.findAll(Sort.by(Sort.Direction.DESC, "createdTimestamp"));
    }

    public String loadNewArticle(MultipartFile file, String category) {
        String message;
        try {
            String content = getContentFromFile(file.getInputStream());
            Article article = getArticleFromContent(content, category);
            articleRepository.save(article);
            message = "it's ok !!!";
        } catch (InputFileHandlingException | IOException ex) {
            message = ex.getMessage();
        }
        return message;
    }
}
