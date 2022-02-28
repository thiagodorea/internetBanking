package com.tdorea.internet.banking.services;

import com.tdorea.internet.banking.dto.ClienteDto;
import com.tdorea.internet.banking.entities.Cliente;
import com.tdorea.internet.banking.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public Page<ClienteDto> findAll(Pageable pageable){
        Page<Cliente> result = repository.findAll(pageable);
        return result.map(ClienteDto::new);
    }


}
