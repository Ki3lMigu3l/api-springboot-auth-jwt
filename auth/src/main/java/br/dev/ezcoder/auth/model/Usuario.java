package br.dev.ezcoder.auth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "roles")
    private List<String> roles;


}
