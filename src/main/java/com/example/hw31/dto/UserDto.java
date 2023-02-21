package com.example.hw31.dto;

import com.example.hw31.model.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *
 * @author Roman Netesa
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;

    private String name;

    private String password;

    private UserRole role;
}
