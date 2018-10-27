package br.edu.ifms.loja.cliente.datamodel;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import com.towel.el.annotation.Resolvable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idCliente;

    @Resolvable(colName = "Nome")
    private String nome;

    @Resolvable(colName = "CPF")
    private String cpf;

    @Resolvable(colName = "Endereço")
    private String endereco;

    @Resolvable(colName = "Numero")
    private String numero;

    @Resolvable(colName = "Data de Nascimento")
    private Date dataNascimento;

    @Resolvable(colName = "E-mail")
    private String email;

    @Resolvable(colName = "Telefone")
    private String telefone;

    @Resolvable(colName = "CEP")
    private String cep;

    @ManyToOne
    private Cidade idCidade;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
