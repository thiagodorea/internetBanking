package com.tdorea.internet.banking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdorea.internet.banking.entities.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDto {

    private Long idTansacao;
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataMovimentacao;
    private String operacao;
    private BigDecimal valor;

    public TransacaoDto() {
    }

    public TransacaoDto(Long idTansacao, LocalDate dataMovimentacao, String operacao, BigDecimal valor) {
        this.idTansacao = idTansacao;
        this.dataMovimentacao = dataMovimentacao;
        this.operacao = operacao;
        this.valor = valor;
    }

    public TransacaoDto(Transacao entity) {
        idTansacao = entity.getIdTansacao();
        dataMovimentacao = entity.getDataMovimentacao();
        operacao = entity.getOperacao();
        valor = entity.getValor();
    }

    public Long getIdTansacao() {
        return idTansacao;
    }

    public void setIdTansacao(Long idTansacao) {
        this.idTansacao = idTansacao;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
