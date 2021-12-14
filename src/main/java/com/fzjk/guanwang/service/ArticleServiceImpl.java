package com.fzjk.guanwang.service;

import com.fzjk.guanwang.NotFoundException;
import com.fzjk.guanwang.dao.ArticleRepository;
import com.fzjk.guanwang.pojo.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public Article findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Transactional
    @Override
    public Article findById(Long id) {
        Article a = articleRepository.getById(id);
        if (a == null){
            throw new NotFoundException("没有这篇文章");
        }
        return a;
    }

    @Transactional
    @Override
    public Page<Article> listArticlesByTypeId(Pageable pageable, Long id) {
        return null;
    }

    @Transactional
    @Override
    public Page<Article> listArticle(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    @Override
    public Article update(Long id, Article article) {
        Article a = articleRepository.getById(id);
        if (a == null){
            throw new NotFoundException("不存在该篇文章");
    }
        BeanUtils.copyProperties(article,a);
        return articleRepository.save(a);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
