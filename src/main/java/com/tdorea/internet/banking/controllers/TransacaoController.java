package com.tdorea.internet.banking.controllers;

import com.tdorea.internet.banking.dto.ContaDto;
import com.tdorea.internet.banking.dto.TransacaoDto;
import com.tdorea.internet.banking.services.TransacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "API REST Contas")
@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @ApiOperation(value = "Retorna uma lista paginada de Transações")
    @GetMapping(value = "/lista")
    public ResponseEntity<Page<TransacaoDto>> findAll(Pageable pageable){
        Page<TransacaoDto> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
}
