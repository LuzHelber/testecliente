package br.com.helber.testecliente.application;

import br.com.helber.testecliente.domain.Cliente;
import br.com.helber.testecliente.infra.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }
    public Optional<Cliente> getByNome(String nome){
        return repository.findByNome(nome);
    }
}
