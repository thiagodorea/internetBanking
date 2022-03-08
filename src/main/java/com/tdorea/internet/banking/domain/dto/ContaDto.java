package com.tdorea.internet.banking.domain.dto;

import com.tdorea.internet.banking.entities.Conta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "Conta")
public class ContaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id da Conta")
    private Long idConta;

    @NotBlank(message = "Informar o número da agência é Obrigatório")
    @ApiModelProperty(value = "Numero da Agência",required = true)
    private String agencia;

    @NotBlank(message = "Informar o número da conta é Obrigatório")
    @ApiModelProperty(value = "Numero da Conta",required = true)
    private String nConta;

    @ApiModelProperty(value = "Cliente exclusivo")
    private Boolean exclusive;

    @NotBlank
    @ApiModelProperty(value = "Saldo da Conta")
    private BigDecimal saldo;

    @ApiModelProperty(value = "Id do Cliente")
    private Long idCliente;

    public ContaDto() {
    }

    public ContaDto(Long idConta, String agencia, String nConta, Boolean exclusive, BigDecimal saldo, Long idCliente) {
        this.idConta = idConta;
        this.agencia = agencia;
        this.nConta = nConta;
        this.exclusive = exclusive;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public ContaDto(Conta entity) {
        idConta = entity.getIdConta();
        agencia = entity.getAgencia();
        nConta = entity.getnConta();
        exclusive = entity.getExclusive();
        saldo = entity.getSaldo();
        idCliente = entity.getCliente().getIdCliente();
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getnConta() {
        return nConta;
    }

    public void setnConta(String nConta) {
        this.nConta = nConta;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
