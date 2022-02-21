package com.tdorea.internet.banking.repositories;

import com.tdorea.internet.banking.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
