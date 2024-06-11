package com.exemplo.lojavirtual.controllers;

import com.exemplo.lojavirtual.models.Produto;
import com.exemplo.lojavirtual.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarProduto(@ModelAttribute Produto produto) {
        produtoService.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/alteracao/{id}")
    public String showAlteracaoForm(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id);
        model.addAttribute("produto", produto);
        return "produtos/alteracao";
    }

    @PostMapping("/alteracao")
    public String alterarProduto(@ModelAttribute Produto produto) {
        produtoService.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.findAll());
        return "produtos/index";
    }

    @GetMapping("/consulta/{id}")
    public String consultarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id);
        model.addAttribute("produto", produto);
        return "produtos/consulta";
    }

    @GetMapping("/exclusao/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoService.delete(id);
        return "redirect:/produtos";
    }
}
