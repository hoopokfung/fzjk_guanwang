package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Article save(Article article);

    Article findByTitle(String title);

    Article findById(Long id);

    Page<Article> listArticlesByTypeId(Pageable pageable, Long id);

    Page<Article> listArticle(Pageable pageable);

    List<Article> findAll();

    Article update(Long id, Article article);

    void delete(Long id);
}
