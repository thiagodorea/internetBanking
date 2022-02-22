package com.tdorea.internet.banking.repositories;

import com.tdorea.internet.banking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
