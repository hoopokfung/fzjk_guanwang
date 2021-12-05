package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Transactional
    Article findByTitle(String title);

    @Transactional
    @Query("select a from Article a ")
    List<Article> findTop(Pageable pageable);

    // select * from t_article where title like '%内容%'
    @Query("select a from Article a where a.title like ?1 or a.description like ?1")
    Page<Article> findByQuery(String query,Pageable pageable);

    @Query("update Article a set a.views = a.views+1 where a.id = ?1")
    int updateViews(Long id);
}
