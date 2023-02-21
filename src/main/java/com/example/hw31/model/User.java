package com.example.hw31.model;

import jakarta.persistence.*;
import lombok.*;

/*
 *
 * @author Roman Netesa
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "my_shop")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
