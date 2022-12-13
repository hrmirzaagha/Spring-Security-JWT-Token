package com.software.tokens.service;

import com.software.tokens.exception.ObjectNotFoundException;
import com.software.tokens.model.User;
import com.software.tokens.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements GeneralService<User> {

    private final UserRepository userRepository;

    @Override
    public List<User> selectAll() {

        Optional<List<User>> usersOptional = Optional.of(userRepository.findAll());

        return usersOptional.isPresent() ? usersOptional.get() : usersOptional.orElseThrow(() ->
                new ObjectNotFoundException("The user not found."));
    }

    @Override
    public Page<User> selectAll(Pageable pageable) {

        Optional<Page<User>> usersOptional = Optional.of(userRepository.findAll(pageable));

        return usersOptional.isPresent() ? usersOptional.get() : usersOptional.orElseThrow(() ->
                new ObjectNotFoundException("The user not found."));
    }

    @Override
    public User selectById(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        return userOptional.isPresent() ? userOptional.get() : userOptional.orElseThrow(() ->
                new ObjectNotFoundException(String.format("The user by id: %d not found", id)));
    }

    @Override
    public User saveOrUpdate(User user) {

        if (user != null) {
            return userRepository.findById(user.getId())
                    .orElseGet(() -> {
                        User selectedUser = User.builder()
                                .firstname(user.getFirstname())
                                .lastname(user.getLastname())
                                .birtDate(user.getBirtDate())
                                .contacts(user.getContacts())
                                .roles(user.getRoles())
                                .usernamePassword(user.getUsernamePassword())
                                .build();
                        return userRepository.save(selectedUser);
                    });
        } else {
            throw new ObjectNotFoundException("The user not null");
        }
    }

    @Override
    public void delete(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(userOptional.get().getId());
        } else {
            userOptional.orElseThrow(() ->
                    new ObjectNotFoundException(String.format("The user by id: %d not found", id)));
        }

    }

    @Override
    public void delete(User user) {

        if (user != null && user.getId() != 0) {

            Optional<User> userOptional = userRepository.findById(user.getId());
            userRepository.delete(userOptional.get());

        } else {
            throw new ObjectNotFoundException(String.format("The user: %s %s not found.", user.getFirstname(), user.getLastname()));
        }
    }
}
