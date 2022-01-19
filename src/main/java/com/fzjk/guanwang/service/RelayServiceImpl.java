package com.fzjk.guanwang.service;

import com.fzjk.guanwang.NotFoundException;
import com.fzjk.guanwang.dao.RelayRepository;
import com.fzjk.guanwang.pojo.Relay;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RelayServiceImpl implements RelayService {

    @Autowired
    private RelayRepository relayRepository;

    @Override
    public Relay save(Relay relay) {
        if(relay.getId()==null){ //如果文章id为空则为新增，有id则为修改
            relay.setCreateTime(new Date()); //保存文章创建时间(当前时间)
        }
        relay.setUpdateTime(new Date());
        return relayRepository.save(relay);
    }

    @Override
    public void delete(Long id) {
        relayRepository.deleteById(id);
    }

    @Override
    public Relay update(Long id, Relay relay) {
        Relay relay1 = relayRepository.getById(id);
        if (relay1 == null) {
            throw new NotFoundException("不存在id为"+id+"的对象");
        }
        BeanUtils.copyProperties(relay,relay1);//将relay的值赋给relay1
        return relayRepository.save(relay1);
    }

    @Override
    public Relay getById(Long id) {
        return relayRepository.getById(id);
    }

    @Override
    public List<Relay> listAll() {
        return relayRepository.findAll();
    }

    @Override
    public Page<Relay> findAll(Pageable pageable) {
        return relayRepository.findAll(pageable);
    }
}
