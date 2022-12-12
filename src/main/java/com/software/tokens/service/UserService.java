package com.software.tokens.service;

import com.software.tokens.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements GeneralService<User>{

    @Override
    public Optional<List<User>> selectAll() {
        return Optional.empty();
    }

    @Override
    public Optional<User> selectById(Long id) {
        return Optional.empty();
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public Long delete(User user) {
        return null;
    }
}
