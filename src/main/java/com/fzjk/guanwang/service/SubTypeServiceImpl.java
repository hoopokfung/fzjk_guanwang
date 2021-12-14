package com.fzjk.guanwang.service;

import com.fzjk.guanwang.NotFoundException;
import com.fzjk.guanwang.dao.SubTypeRepository;
import com.fzjk.guanwang.pojo.SubType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubTypeServiceImpl implements SubTypeService {

    @Autowired
    private SubTypeRepository subTypeRepository;

    @Transactional
    @Override
    public SubType save(SubType subType) {
        return subTypeRepository.save(subType);
    }

    @Transactional
    @Override
    public SubType findByName(String name) {
        return subTypeRepository.findSubTypeByName(name);
    }

    @Transactional
    @Override
    public SubType findById(Long id) {
        //jpa的findById方法也可以，返回类型是Optional<T>：表示可以含对象也可以为空，可避免做空指针判断
        return subTypeRepository.getById(id);
    }

    @Transactional
    @Override
    public Page<SubType> listSubTypesByTypeId(Pageable p ,Long id){
        return subTypeRepository.findSubTypesByTypeId(p,id);
    }


    @Transactional
    @Override
    public Page<SubType> listSubType(Pageable pageable) {
        return subTypeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public List<SubType> findAll() {
        return subTypeRepository.findAll();
    }

    @Transactional
    @Override
    public SubType update(Long id, SubType subType) {
        SubType st = subTypeRepository.getById(id);
        if (st == null) {
            throw new NotFoundException("不存在id为"+id+"子类对象");
        }
        BeanUtils.copyProperties(subType,st);
        return subTypeRepository.save(st);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        subTypeRepository.deleteById(id);
    }
}
