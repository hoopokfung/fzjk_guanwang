package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.vo.PreAndNextArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Article save(Article article);

    Article findByTitle(String title);

    Article findById(Long id);

    List<Article> findTop(Long subTypeId,int n);

    List<Article> findTopByTypeId(Long typeId);

    Page<Article> listArticlesByTypeId(Pageable pageable, Long id);

    Page<Article> listArticlesBySubTypeId(Pageable pageable, Long id);

    Page<Article> listArticle(Pageable pageable);

    List<Article> findAll();

    int updateViews(Long id);

    Article update(Long id, Article article);

    void delete(Long id);

    PreAndNextArticle getPreArticle(Long id, Long subTypeId);

    PreAndNextArticle getNextArticle(Long id,Long subTypeId);
}
