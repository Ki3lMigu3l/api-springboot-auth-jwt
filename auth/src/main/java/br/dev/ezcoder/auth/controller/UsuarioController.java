package br.dev.ezcoder.auth.controller;

import br.dev.ezcoder.auth.controller.dto.UsuarioDTO;
import br.dev.ezcoder.auth.controller.mapper.UsuarioMapper;
import br.dev.ezcoder.auth.model.Usuario;
import br.dev.ezcoder.auth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController {

    final UsuarioService service;
    final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UsuarioDTO request) {

        Usuario user = mapper.toEntity(request);
        service.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Usuario> getUsers() {
        return service.getUsers();
    }
}
