package br.dev.ezcoder.auth.controller.mapper;

import br.dev.ezcoder.auth.controller.dto.UsuarioDTO;
import br.dev.ezcoder.auth.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO userDTO);
}
