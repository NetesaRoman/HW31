package com.example.hw31.service;

import com.example.hw31.dto.UserDto;
import com.example.hw31.model.User;
import com.example.hw31.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 *
 * @author Roman Netesa
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        userDto.setId(user.getId());

        return userDto;
    }

    public boolean hasUserByName(String name) {
        return  userRepository.existsUserByName(name);
    }

}
