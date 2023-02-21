package com.example.hw31;

import com.example.hw31.dto.ProductDto;
import com.example.hw31.dto.UserDto;
import com.example.hw31.model.UserRole;
import com.example.hw31.service.ProductService;
import com.example.hw31.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class Hw31Application {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Hw31Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){

        if(!userService.hasUserByName("admin@admin")) {
            userService.createUser(
                    new UserDto(null, "admin@admin","12032003", UserRole.ADMIN));
        }

        if(!userService.hasUserByName("user@user")) {
            userService.createUser(
                    new UserDto(null, "user@user","12032003", UserRole.USER));
        }


    }

}
