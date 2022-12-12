package com.software.tokens.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {

    Optional<List<T>> selectAll();

    Page<T> selectAll(Pageable pageable);

    Optional<T> selectById(Long id);

    T saveOrUpdate(T t);

    Long delete(Long id);

    Long delete(T t);

}
