package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.sql.SQLException;
import java.util.List;

public class FornecedorBO {

    private FornecedorDAO dao;

    public FornecedorBO() throws SQLException {
        dao = new FornecedorDAO();
    }
    
    public void inserirFornecedor(Fornecedor fornecedor){
        dao.inserir(fornecedor);
    }
    
    public void removerFornecedor(Fornecedor fornecedor){
        dao.remover(fornecedor);
    }
    
    public List<Fornecedor> listarTodos(){
        return dao.listarTodos();
    }
    
    public Fornecedor buscarPorId(Long id){
        return dao.buscarPorId(id);
    }

}
