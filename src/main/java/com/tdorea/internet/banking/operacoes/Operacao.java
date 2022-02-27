package com.tdorea.internet.banking.operacoes;

import com.tdorea.internet.banking.entities.Conta;
import com.tdorea.internet.banking.enuns.TipoOperacao;
import com.tdorea.internet.banking.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class Operacao {

    @Autowired
    private TransacaoService service;

    public BigDecimal sacar(Conta conta, BigDecimal valor){

        final BigDecimal taxa;
        final boolean clienteExclusivo = conta.getExclusive();

        if(!clienteExclusivo && valor.compareTo(new BigDecimal("100")) > 0 && valor.compareTo(new BigDecimal("300")) <= 0){
            taxa = valor.multiply( new BigDecimal("0.004"));
            valor = valor.add(taxa);
        }else if(!clienteExclusivo && valor.compareTo(new BigDecimal("300")) > 0 ){
            taxa = valor.multiply( new BigDecimal("0.01"));
            valor = valor.add(taxa);
        }
        service.insert(TipoOperacao.SAQUE,valor, conta);
        return conta.getSaldo().subtract(valor).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal depositar(Conta conta, BigDecimal valor){
        service.insert(TipoOperacao.DEPOSITO,valor, conta);
        return conta.getSaldo().add(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
}
