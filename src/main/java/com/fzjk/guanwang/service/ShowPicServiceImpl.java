package com.fzjk.guanwang.service;

import com.fzjk.guanwang.NotFoundException;
import com.fzjk.guanwang.dao.ShowPicRepository;
import com.fzjk.guanwang.pojo.ShowPic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowPicServiceImpl implements ShowPicService {

    @Autowired
    private ShowPicRepository showPicRepository;

    @Override
    public ShowPic save(ShowPic showPic) {
        showPic.setUpdateTime(new Date());
        return showPicRepository.save(showPic);
    }

    @Override
    public void delete(Long id) {
        showPicRepository.deleteById(id);
    }

    @Override
    public ShowPic update(Long id, ShowPic showPic) {
        ShowPic sp = showPicRepository.getById(id);
        if (sp == null){
            throw new NotFoundException("不存在id为"+id+"的对象");
        }
        BeanUtils.copyProperties(showPic,sp);
        return showPicRepository.save(sp);
    }

    @Override
    public ShowPic getById(Long id) {
        return showPicRepository.getById(id);
    }

    @Override
    public List<ShowPic> listAll() {
        return showPicRepository.findAll();
    }

    @Override
    public Page<ShowPic> findAll(Pageable pageable) {
        return showPicRepository.findAll(pageable);
    }
}
