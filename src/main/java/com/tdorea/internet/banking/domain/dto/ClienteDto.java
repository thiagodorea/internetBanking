package com.tdorea.internet.banking.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdorea.internet.banking.entities.Cliente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "Cliente")
public class ClienteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id do Cliente")
    private Long idCliente;

    @NotBlank(message = "O Nome deve ser informado")
    @ApiModelProperty(value = "Nome do Cliente")
    private String nome;

    @NotBlank(message = "O CPF deve ser informado")
    @Size(min = 11,max = 11, message = "CPF deve ter 11 digitos")
    @ApiModelProperty(value = "Número do CPF")
    private String cpf;

    @NotBlank(message = "Data de Nascimento deve ser informado")
    @ApiModelProperty(value = "Data de Nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataNascimento;

    public ClienteDto() {
    }

    public ClienteDto(Long idCliente, String nome, String cpf, LocalDate dataNascimento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public ClienteDto(Cliente entity) {
        idCliente = entity.getIdCliente();
        nome = entity.getNome();
        cpf = entity.getCpf();
        dataNascimento = entity.getDataNascimento();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
