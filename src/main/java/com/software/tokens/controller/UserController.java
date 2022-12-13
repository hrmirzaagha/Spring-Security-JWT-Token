package com.software.tokens.controller;

import com.software.tokens.model.User;
import com.software.tokens.tools.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController extends GeneralController<User>{


    @GetMapping
    @Override
    public ResponseEntity<Response> select() {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> select(Pageable pageable) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> selectById(Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Response> saveOrUpdate(User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(Long id) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(User user) {
        return null;
    }
}
