package com.tdorea.internet.banking.controllers;

import com.tdorea.internet.banking.domain.dto.ContaDto;
import com.tdorea.internet.banking.domain.dto.MovimentacaoDto;
import com.tdorea.internet.banking.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@Api(value = "API REST Contas")
@RestController
@RequestMapping(value = "/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @ApiOperation(value = "Retorna uma lista paginada de Contas")
    @GetMapping(value = "/lista")
    public ResponseEntity<Page<ContaDto>> findAll(Pageable pageable){
        Page<ContaDto> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    @ApiOperation(value = "Retorna uma lista paginada das Movimentações")
    @GetMapping(value = "/lista/movimentacao")
    public ResponseEntity<Page<MovimentacaoDto>> findAllMovement(Pageable pageable){
        Page<MovimentacaoDto> list = service.findAllMovement(pageable);
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Realiza um saque na Contas")
    @PutMapping(value = "{id}/sacar/{valor}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaDto> sacar(@Valid @PathVariable Long id, @PathVariable BigDecimal valor){
        ContaDto dto = service.sacar(id,valor);
        return ResponseEntity.ok().body(dto);
    }
    @ApiOperation(value = "Realiza um deposito na Contas")
    @PutMapping(value = "{id}/depositar/{valor}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaDto> depositar(@Valid @PathVariable Long id, @PathVariable BigDecimal valor){
        ContaDto dto = service.depositar(id,valor);
        return ResponseEntity.ok().body(dto);
    }

}
