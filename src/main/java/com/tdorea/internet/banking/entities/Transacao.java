package com.tdorea.internet.banking.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private Long id;
    private LocalDate dataMovimentacao;
    private String operacao;
    private BigDecimal valor;
}
