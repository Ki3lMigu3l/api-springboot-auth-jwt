package br.dev.ezcoder.auth.controller.dto;

import java.util.List;

public record UsuarioDTO(String username, String email, String password, List<String> roles) {

}
