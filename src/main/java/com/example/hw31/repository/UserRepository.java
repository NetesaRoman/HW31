package com.example.hw31.repository;

import com.example.hw31.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/*
 *
 * @author Roman Netesa
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findFirstByName(String email);

    boolean existsUserByName(String email);
}
