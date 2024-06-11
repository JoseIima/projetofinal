package com.exemplo.lojavirtual.controllers;

import com.exemplo.lojavirtual.models.Pagamento;
import com.exemplo.lojavirtual.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        return "pagamentos/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarPagamento(@ModelAttribute Pagamento pagamento) {
        pagamentoService.save(pagamento);
        return "redirect:/pagamentos";
    }

    @GetMapping("/alteracao/{id}")
    public String showAlteracaoForm(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.findById(id);
        model.addAttribute("pagamento", pagamento);
        return "pagamentos/alteracao";
    }

    @PostMapping("/alteracao")
    public String alterarPagamento(@ModelAttribute Pagamento pagamento) {
        pagamentoService.save(pagamento);
        return "redirect:/pagamentos";
    }

    @GetMapping
    public String listarPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.findAll());
        return "pagamentos/index";
    }

    @GetMapping("/consulta/{id}")
    public String consultarPagamento(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.findById(id);
        model.addAttribute("pagamento", pagamento);
        return "pagamentos/consulta";
    }

    @GetMapping("/exclusao/{id}")
    public String excluirPagamento(@PathVariable Long id) {
        pagamentoService.delete(id);
        return "redirect:/pagamentos";
    }
}
