package br.com.helber.testecliente.domain;

import br.com.helber.testecliente.infra.repository.DadosAlteracaoClientes;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbClientes")
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    @Email
    private String email;

    public Cliente(DadosCadastroClientes dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
    }

    public void atualizaDados(DadosAlteracaoClientes dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
    }
}
