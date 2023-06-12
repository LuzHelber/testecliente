package br.com.helber.testecliente.controller;

import br.com.helber.testecliente.domain.Cliente;
import br.com.helber.testecliente.domain.DadosCadastroClientes;
import br.com.helber.testecliente.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "clientes/formulario";
    }

    @GetMapping
    public String listaPaginaFormulario(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "clientes/lista";
    }

    @PostMapping
    public String cadastraFormulario(DadosCadastroClientes dados) {
        var cliente = new Cliente(dados);
        repository.save(cliente);
        return "redirect:/clientes";
    }

}
