package com.software.tokens.controller;

import com.software.tokens.tools.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public abstract class GeneralController<T> {

    public abstract ResponseEntity<Response> select();

    public abstract ResponseEntity<Response> select(Pageable pageable);

    public abstract ResponseEntity<Response> selectById(@PathVariable(value = "id") Long id);

    public abstract ResponseEntity<Response> saveOrUpdate(@RequestBody T t);

    public abstract ResponseEntity<Response> delete(@PathVariable(value = "id") Long id);

    public abstract ResponseEntity<Response> delete(@RequestBody T t);

}
