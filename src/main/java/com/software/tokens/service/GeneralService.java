package com.software.tokens.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {

    List<T> selectAll();

    Page<T> selectAll(Pageable pageable);

    T selectById(Long id);

    T saveOrUpdate(T t);

    void delete(Long id);

    void delete(T t);

}
