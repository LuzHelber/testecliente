package br.com.helber.testecliente.controller;

import br.com.helber.testecliente.domain.Cliente;
import br.com.helber.testecliente.domain.DadosCadastroClientes;
import br.com.helber.testecliente.infra.repository.ClienteRepository;
import br.com.helber.testecliente.infra.repository.DadosAlteracaoClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if(id != null) {
            var cliente = repository.getReferenceById(id);
            model.addAttribute("cliente", cliente);
        }
        return "clientes/formulario";
    }

    @GetMapping
    public String listaPaginaFormulario(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "clientes/lista";
    }

    @PostMapping
    @Transactional
    public String cadastraFormulario(DadosCadastroClientes dados) {
        var cliente = new Cliente(dados);
        repository.save(cliente);
        return "redirect:/clientes";
    }
    @PutMapping
    @Transactional
    public String editarFormulario(DadosAlteracaoClientes dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizaDados(dados);
        return "redirect:/clientes";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String excluiCliente(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/clientes";
    }
}
