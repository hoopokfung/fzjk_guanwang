package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.Relay;
import javafx.geometry.Point3DBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelayRepository extends JpaRepository<Relay, Long> {

}
