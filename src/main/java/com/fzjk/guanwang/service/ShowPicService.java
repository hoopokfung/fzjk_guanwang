package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.ShowPic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShowPicService {

    ShowPic save(ShowPic showPic);

    void delete(Long id);

    ShowPic update(Long id,ShowPic showPic);

    ShowPic getById(Long id);

    List<ShowPic> listAll();

    Page<ShowPic> findAll(Pageable pageable);

}
