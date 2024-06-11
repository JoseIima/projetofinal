package com.exemplo.lojavirtual.repositories;

import com.exemplo.lojavirtual.models.Pagamento;
import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
}
