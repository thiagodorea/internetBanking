package com.tdorea.internet.banking.services;

import com.tdorea.internet.banking.domain.dto.ClienteDto;
import com.tdorea.internet.banking.domain.mapper.ClienteMapper;
import com.tdorea.internet.banking.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional(readOnly = true)
    public Page<ClienteDto> findAll(Pageable pageable){
        return clienteRepository.findAll(pageable).map(ClienteDto::new);
    }


}
