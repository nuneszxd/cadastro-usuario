package com.nunesz.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name")
    private String name;
}
