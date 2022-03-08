package com.tdorea.internet.banking.domain.mapper;

import com.tdorea.internet.banking.domain.dto.ClienteDto;
import com.tdorea.internet.banking.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    List<ClienteDto> toDto(List<Cliente> clientes);
    ClienteDto toClienteDto(Cliente cliente);
}
