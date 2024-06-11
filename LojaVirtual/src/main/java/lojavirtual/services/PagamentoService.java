package com.exemplo.lojavirtual.services;

import com.exemplo.lojavirtual.models.Pagamento;
import com.exemplo.lojavirtual.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return (List<Pagamento>) pagamentoRepository.findAll();
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }
}
