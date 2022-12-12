package com.software.tokens.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {

    Optional<List<T>> selectAll();

    Optional<T> selectById(Long id);

    T saveOrUpdate(T t);

    Long delete(Long id);

    Long delete(T t);

}
