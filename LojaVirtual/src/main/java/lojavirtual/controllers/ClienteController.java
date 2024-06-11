package com.exemplo.lojavirtual.controllers;

import com.exemplo.lojavirtual.models.Cliente;
import com.exemplo.lojavirtual.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/alteracao/{id}")
    public String showAlteracaoForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "clientes/alteracao";
    }

    @PostMapping("/alteracao")
    public String alterarCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes/index";
    }

    @GetMapping("/consulta/{id}")
    public String consultarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "clientes/consulta";
    }

    @GetMapping("/exclusao/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}
