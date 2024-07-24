package dev.imrob.tutorialcrud.mapper;

import dev.imrob.tutorialcrud.dto.ClienteDTO;
import dev.imrob.tutorialcrud.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toDto(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);

    List<ClienteDTO> toDto(List<Cliente> entities);

    List<Cliente> toEntity(List<ClienteDTO> dtos);
}
