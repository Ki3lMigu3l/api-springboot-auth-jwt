package br.dev.ezcoder.auth.service;

import br.dev.ezcoder.auth.model.Usuario;
import br.dev.ezcoder.auth.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    final UsuarioRepository repository;
    final PasswordEncoder encoder;

    public void save(Usuario user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    public Usuario findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Usuario> getUsers() {
        return repository.findAll();
    }

}
