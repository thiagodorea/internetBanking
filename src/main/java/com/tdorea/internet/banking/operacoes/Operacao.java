package com.tdorea.internet.banking.operacoes;

import com.tdorea.internet.banking.entities.Conta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class Operacao {

    public BigDecimal sacar(Conta conta, BigDecimal valor){

        BigDecimal taxa;

        if(!conta.getExclusive() && valor.compareTo(new BigDecimal("100")) > 0 && valor.compareTo(new BigDecimal("300")) <= 0){
            taxa = valor.multiply( new BigDecimal("0.004"));
            valor = valor.add(taxa);
        }else if(!conta.getExclusive() && valor.compareTo(new BigDecimal("300")) > 0 ){
            taxa = valor.multiply( new BigDecimal("0.01"));
            valor = valor.add(taxa);
        }
        return conta.getSaldo().subtract(valor).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal depositar(Conta conta, BigDecimal valor){
        return conta.getSaldo().add(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
}
