package br.dev.ezcoder.auth.security;

import br.dev.ezcoder.auth.model.Usuario;
import br.dev.ezcoder.auth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    final UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = service.findByUsername(username);

        if (user == null){
           throw new UsernameNotFoundException("User not found!");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().toArray(new String[0]))
                .build();
    }
}
