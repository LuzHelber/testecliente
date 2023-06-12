package br.com.helber.testecliente.application;

import br.com.helber.testecliente.application.response.ErrorResponse;
import br.com.helber.testecliente.application.response.SuccessResponse;
import br.com.helber.testecliente.domain.Cliente;
import br.com.helber.testecliente.domain.DadosCadastroClientes;
import jakarta.ws.rs.Produces;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteResource {

    private final ClienteService service;

    @GetMapping
    public String status(){
       return "Hello World!!";
    }
    @PostMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody DadosCadastroClientes dados) {
        try {
            Cliente cliente = new Cliente(dados);
            Cliente savedCliente = service.save(cliente);

            String successMessage = "Cliente " + savedCliente.getNome() + " cadastrado com sucesso!";
            SuccessResponse successResponse = new SuccessResponse(HttpStatus.CREATED.value(), successMessage);
            return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Erro ao salvar o cliente.", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping(params = "nome")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> dadosCliente(@RequestParam("nome") String nome){
        Optional<Cliente> cliente = service.getByNome(nome);
        if(cliente.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                    "Cliente não encontrado.", "Cliente não encontrado com o nome especificado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(cliente.get());
    }

}
