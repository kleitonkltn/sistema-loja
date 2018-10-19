package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cliente.dao.ClienteDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.cliente.exception.NomeInvalidoException;
import java.sql.SQLException;
import java.util.List;

public class ClienteBO {

    private ClienteDAO daoCliente;

    public ClienteBO() throws SQLException {
        daoCliente = new ClienteDAO();
    }

    public void inserirCiente(Cliente cliente) {
        daoCliente.inserir(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        daoCliente.atualizar(cliente);
    }

    public void excluirCliente(Long id) {
        daoCliente.remover(id);
    }

    public List<Cliente> buscarClientePorCpf(String cpf) {
        return daoCliente.buscarPorCpf(cpf);
    }

    public List<Cliente> buscarClientePorNome(String nome) {
        return daoCliente.buscarClientePorNome(nome);
    }

    public List<Cliente> listarTodosOsClientes() {
        return daoCliente.listarTodos();
    }
    
    public List<Cliente> buscarClientePorNomeOuCPF(String param){
        return daoCliente.buscarClientePorNomeOuCPF(param, param);
    }
}
