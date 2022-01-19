package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Transactional
    Article findByTitle(String title);


    /*
    * 加入nativeQuery注解时，写原生sql，支持limit函数
    * 不加入nativeQuery注解时是JPQL，JPQL不支持limit函数。
    * */
    @Transactional
    @Query(nativeQuery = true,value = "select * from t_article  where sub_type_id = ? order by update_time desc limit ?")
    List<Article> findTop(Long subTypeId,int n);


    @Transactional
    @Query(nativeQuery = true,value = "select * from t_article  where type_id = ? order by update_time desc limit 3")
    List<Article> findTopByTypeId(Long typeId);

    // select * from t_article where title like '%内容%'
    @Query("select a from Article a where a.title like ?1 or a.description like ?1")
    Page<Article> findByQuery(String query,Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Article a set a.views = a.views+1 where a.id = ?1")
    int updateViews(Long id);

    @Transactional
    @Query("select a from Article a where a.subType.id = ?1 order by a.id")
    List<Article> listAllBySubTypeId(Long subTypeId);

    @Transactional
    Page<Article> findAllBySubTypeId(Pageable pageable,Long id);

    @Transactional
    Page<Article> findAllByTypeId(Pageable pageable,Long id);
}
