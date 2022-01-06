package com.fzjk.guanwang.service;

import com.fzjk.guanwang.NotFoundException;
import com.fzjk.guanwang.dao.ArticleRepository;
import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.util.MyBeanUtils;
import com.fzjk.guanwang.vo.PreAndNextArticle;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findTop(Long subTypeId){
        List<Article> articles =  articleRepository.findTop(subTypeId);
        return articles;
    }


    @Transactional
    @Override
    public Article save(Article article) {
        if(article.getId()==null){ //如果文章id为空则为新增，有id则为修改
            article.setCreateTime(new Date()); //保存文章创建时间(当前时间)
            article.setUpdateTime(new Date());
            article.setViews(0); //文章浏览量初始化
        }else {
            article.setUpdateTime(new Date());
        }
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
        return articleRepository.findAllByTypeId(pageable,id);
    }

    @Transactional
    @Override
    public Page<Article> listArticle(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Page<Article> listArticlesBySubTypeId(Pageable pageable,Long id) {
        return articleRepository.findAllBySubTypeId(pageable,id);
    }

    @Transactional
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public int updateViews(Long id) {
        return articleRepository.updateViews(id);
    }

    @Transactional
    @Override
    public Article update(Long id, Article article) {
        Article a = articleRepository.getById(id);
        if (a == null){
            throw new NotFoundException("不存在该篇文章");
        }
        //将article的值给a，MyBeanUtils工具类过滤掉属性值为空的属性，这样当属性值为空则保留原有值，执行更新操作
        BeanUtils.copyProperties(article,a, MyBeanUtils.getNullPropertyNames(article));// 将article里面的值赋值给a
        return articleRepository.save(a);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }


    public PreAndNextArticle getPreArticle(Long id, Long subTypeId){
        PreAndNextArticle preArticle = new PreAndNextArticle();
        Long preId = null;
        Long[] LongId = listArticles(subTypeId);
        //获取当前id的上一个id下标
        for (int j = 0 ; j < LongId.length ; j++){
            if (LongId[j].equals(id)){
                int i = j-1;
                if (i >= 0){
                    preId = LongId[i];
                    break;
                }
                break;
            }
        }
        isPreAndNext(preArticle,preId);
        return preArticle;
    }

    public PreAndNextArticle getNextArticle(Long id, Long subTypeId){
        PreAndNextArticle nextArticle = new PreAndNextArticle();
        Long nextId = null;
        Long[] LongId = listArticles(subTypeId);
        //获取当前id的下一个id下标
        for (int j = 0 ; j < LongId.length ; j++){
            if (LongId[j].equals(id)){
                int i = j+1;
                if (i < LongId.length){
                    nextId = LongId[i];
                    break;
                }
                break;
            }
        }
        isPreAndNext(nextArticle,nextId);
        return nextArticle;
    }

    public Long[] listArticles(Long subTypeId){
        List<Article> list;
        //查询该分类下的集合
        list = articleRepository.listAllBySubTypeId(subTypeId);
        //获取集合长度
        int count = list.size();
        //将该分类下的id放入数组中
        Long[] LongId = new Long[count];
        for (int i = 0 ; i < count ; i++){
            LongId[i] = list.get(i).getId();
        }
        return LongId;
    }

    private void isPreAndNext(PreAndNextArticle preAndNext , Long preId){
        if (preId == null){
            preAndNext.setId(null);
            preAndNext.setTitle("没有了");
        } else {
            //将上一页id和标题赋值返回
            Article a = articleRepository.getById(preId);
            preAndNext.setId(a.getId());
            preAndNext.setTitle(a.getTitle());
        }
    }



}
