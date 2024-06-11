package com.exemplo.lojavirtual.repositories;

import com.exemplo.lojavirtual.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
