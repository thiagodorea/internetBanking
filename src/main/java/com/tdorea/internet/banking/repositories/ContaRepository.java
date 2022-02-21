package com.tdorea.internet.banking.repositories;

import com.tdorea.internet.banking.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
