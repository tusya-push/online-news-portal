package com.example.onlinenewsportal.repository;

import com.example.onlinenewsportal.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}