package com.tdorea.internet.banking.dto;

import com.tdorea.internet.banking.entities.Conta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel(value = "Movimentação")
public class MovimentacaoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Nome do Cliente")
    private String nomeCliente;

    @NotBlank
    @ApiModelProperty(value = "Numero da Conta")
    private String nConta;

    @ApiModelProperty(value = "Lista de transações")
    private List<TransacaoDto> transacoes = new ArrayList<>();

    public MovimentacaoDto() {
    }

    public MovimentacaoDto(String nomeCliente, String nConta) {
        this.nomeCliente = nomeCliente;
        this.nConta = nConta;
    }
    public MovimentacaoDto(Conta entity) {
        nomeCliente = entity.getCliente().getNome();
        nConta = entity.getnConta();
        transacoes = entity.getTransacaos().stream().map(x -> new TransacaoDto(x)).collect(Collectors.toList());
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getnConta() {
        return nConta;
    }

    public void setnConta(String nConta) {
        this.nConta = nConta;
    }

    public List<TransacaoDto> getTransacoes() {
        return transacoes;
    }

}
