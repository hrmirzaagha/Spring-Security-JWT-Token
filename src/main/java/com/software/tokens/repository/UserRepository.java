package com.software.tokens.repository;

import com.software.tokens.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //Query for select user based username

    @Query("select u from User u join fetch u.usernamePassword up where up.username = :username")
    Optional<User> findUserByUsername(String username);

}
