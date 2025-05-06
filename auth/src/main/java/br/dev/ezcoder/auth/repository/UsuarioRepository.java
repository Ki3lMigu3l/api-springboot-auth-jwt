package br.dev.ezcoder.auth.repository;

import br.dev.ezcoder.auth.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);
}
