package br.dev.ezcoder.auth.security;

import br.dev.ezcoder.auth.model.Usuario;
import br.dev.ezcoder.auth.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    final UsuarioService service;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User auth2User = authToken.getPrincipal();

        Usuario user = service.findByEmail(auth2User.getAttribute("email"));

        if(user == null){
            user = new Usuario();
            user.setUsername(auth2User.getAttribute("name"));
            user.setEmail(auth2User.getAttribute("email"));
            user.setPassword("PASSWORD");
            user.setRoles(List.of("USER"));
            service.save(user);
        }

        authentication = new CustomAuthentication(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
