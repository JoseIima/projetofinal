package com.exemplo.lojavirtual.repositories;

import com.exemplo.lojavirtual.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
