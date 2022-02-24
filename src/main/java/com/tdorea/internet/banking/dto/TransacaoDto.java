package com.tdorea.internet.banking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdorea.internet.banking.entities.Transacao;
import com.tdorea.internet.banking.enuns.TipoOperacao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "Transação")
public class TransacaoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id da transação")
    private Long idTansacao;

    @ApiModelProperty(value = "Data da transação")
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataMovimentacao;

    @ApiModelProperty(value = "Tipo de operação")
    private TipoOperacao operacao;

    @NotBlank(message = "Informar o Valor é Obrigatório")
    @ApiModelProperty(value = "Valor da Operação",required = true)
    private BigDecimal valor;

    @NotBlank(message = "Número da Conta é Obrigatório")
    @ApiModelProperty(value = "Número da Conta", required = true)
    private Long idConta;

    public TransacaoDto() {
    }

    public TransacaoDto(Long idTansacao, LocalDate dataMovimentacao, TipoOperacao operacao, BigDecimal valor, Long idConta) {
        this.idTansacao = idTansacao;
        this.dataMovimentacao = dataMovimentacao;
        this.operacao = operacao;
        this.valor = valor;
        this.idConta = idConta;
    }

    public TransacaoDto(Transacao entity) {
        idTansacao = entity.getIdTansacao();
        dataMovimentacao = entity.getDataMovimentacao();
        operacao = entity.getOperacao();
        valor = entity.getValor();
        idConta =entity.getConta().getIdConta();
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

    public TipoOperacao getOperacao() {
        return operacao;
    }

    public void setOperacao(TipoOperacao operacao) {
        this.operacao = operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
}
