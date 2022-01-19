package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.Relay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RelayService {

    Relay save(Relay relay);

    void delete(Long id);

    Relay update(Long id,Relay relay);

    Relay getById(Long id);

    List<Relay> listAll();

    Page<Relay> findAll(Pageable pageable);

}
