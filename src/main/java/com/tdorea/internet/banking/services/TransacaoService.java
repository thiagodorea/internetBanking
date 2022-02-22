package com.tdorea.internet.banking.services;

import com.tdorea.internet.banking.dto.TransacaoDto;
import com.tdorea.internet.banking.entities.Transacao;
import com.tdorea.internet.banking.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Transactional(readOnly = true)
    public Page<TransacaoDto> findAll(Pageable pageable){
        Page<Transacao> result = repository.findAll(pageable);
        return result.map(x -> new TransacaoDto(x));
    }

}
