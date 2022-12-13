package com.software.tokens.controller;

import com.software.tokens.model.User;
import com.software.tokens.service.UserService;
import com.software.tokens.tools.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController extends GeneralController<User> {

    private final UserService userService;

    @GetMapping
    @Override
    public ResponseEntity<Response> select() {
        return null;
    }

    @GetMapping("/page")
    @Override
    public ResponseEntity<Response> select(Pageable pageable) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> selectById(@PathVariable(value = "id") Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Response> saveOrUpdate(User user) {
        return ResponseEntity.ok().body(
                Response.builder()
                        .timeStamp(LocalDate.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("A new User has Registered.")
                        .data(Map.of("users", userService.saveOrUpdate(user)))
                        .build());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Long id) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(User user) {
        return null;
    }
}
