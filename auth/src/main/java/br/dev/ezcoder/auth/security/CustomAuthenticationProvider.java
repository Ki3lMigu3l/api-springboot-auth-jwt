package br.dev.ezcoder.auth.security;

import br.dev.ezcoder.auth.model.Usuario;
import br.dev.ezcoder.auth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    final UsuarioService service;
    final PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario userFound = service.findByUsername(username);

        if(userFound == null) {
            throw getErrorUserNotFound();
        }

        String passwordEncrypt = userFound.getPassword();
        boolean validatePasswords = encoder.matches(password, passwordEncrypt);

        if(validatePasswords) {
            return new CustomAuthentication(userFound);
        }

        throw getErrorUserNotFound();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }

    public static UsernameNotFoundException getErrorUserNotFound() {
        return new UsernameNotFoundException("User and/or Password incorrect");
    }
}
