package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.sql.SQLException;
import java.util.List;

public class FornecedorBO extends GenericBO<Fornecedor>{

    private FornecedorDAO dao;

    public FornecedorBO() throws SQLException {
        super(Fornecedor.class);
        dao = new FornecedorDAO();
    }
    public List<Fornecedor> buscarFornecedorPorNomeFantasia(String nome) {
        return dao.buscarFornecedorPorNomeFantasia(nome);
    }
}
