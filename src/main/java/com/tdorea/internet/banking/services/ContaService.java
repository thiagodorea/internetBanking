package com.tdorea.internet.banking.services;

import com.tdorea.internet.banking.dto.ContaDto;
import com.tdorea.internet.banking.dto.MovimentacaoDto;
import com.tdorea.internet.banking.entities.Conta;
import com.tdorea.internet.banking.operacoes.Operacao;
import com.tdorea.internet.banking.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private Operacao operacao;

    @Transactional(readOnly = true)
    public Page<ContaDto> findAll(Pageable pageable){
        Page<Conta> result = repository.findAll(pageable);
        return result.map(x -> new ContaDto(x));
    }
    @Transactional(readOnly = true)
    public Page<MovimentacaoDto> findAllMovement(Pageable pageable){
        Page<Conta> result = repository.findAll(pageable);
        return result.map(x -> new MovimentacaoDto(x));
    }

    @Transactional
    public ContaDto sacar(Long id, BigDecimal valor){
        Conta conta = repository.getById(id);
        conta.setSaldo(operacao.sacar(conta, valor));
        conta = repository.save(conta);
        return new ContaDto(conta);
    }
    @Transactional
    public ContaDto depositar(Long id, BigDecimal valor){
        Conta conta = repository.getById(id);
        conta.setSaldo(operacao.depositar(conta, valor));
        conta = repository.save(conta);
        return new ContaDto(conta);
    }
}
