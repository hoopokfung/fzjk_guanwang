package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.SubType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubTypeService {

    SubType save(SubType subType);

    SubType findByName(String name);

    SubType findById(Long id);

    Page<SubType> listSubTypesByTypeId(Pageable pageable,Long id);

    Page<SubType> listSubType(Pageable pageable);

    List<SubType> findAll();

    SubType update(Long id, SubType subType);

    void delete(Long id);

}
