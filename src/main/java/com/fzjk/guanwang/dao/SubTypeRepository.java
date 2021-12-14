package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.SubType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Long> {

    SubType findSubTypeByName(String name);

    @Query("select s from SubType s")
    List<SubType> findTop(Pageable pageable);

    Page<SubType> findSubTypesByTypeId(Pageable pageable,Long id);
}
