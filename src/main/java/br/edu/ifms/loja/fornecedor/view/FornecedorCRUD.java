/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.fornecedor.bo.FornecedorBO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class FornecedorCRUD extends GenericCRUD<Fornecedor> {
    
    private Fornecedor fornencedor;
    private FornecedorBO fornecedorBO;
    private FornecedorFormulario formularioFornecedor2;
    
    public FornecedorCRUD(Frame parent, boolean modal) {
        super(parent, modal, Fornecedor.class, new String[]{"id", "nome", "cnpj"});
        
        try {
            fornecedorBO = new FornecedorBO();
            carregarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }
    
    @Override
    protected JPanel criarFormulario() {
        formularioFornecedor2 = new FornecedorFormulario();
        return formularioFornecedor2;
    }
    
    @Override
    protected void camposParaObjeto() {
        fornencedor.setNome(formularioFornecedor2.getCampoNome().getText());
        fornencedor.setCnpj(formularioFornecedor2.getCampoCNPJ().getText());   
    }
    
    @Override
    protected void objetoParaCampos() {
        formularioFornecedor2.getCampoCNPJ().setText(fornencedor.getCnpj());
        formularioFornecedor2.getCampoNome().setText(fornencedor.getNome());
    }
    
    @Override
    protected void salvar() {
        fornecedorBO.inserirFornecedor(fornencedor);
    }
    
    @Override
    protected void editar() {
        
    }
    
    @Override
    protected void novo() {
        fornencedor = new Fornecedor();
    }
    
    @Override
    protected void cancelar() {
        
    }
    
    @Override
    protected void excluir() {
        fornecedorBO.removerFornecedor(fornencedor);
    }
    
    @Override
    protected List<Fornecedor> carregarListaParaTabela() {
        return fornecedorBO.listarTodos();
    }
    
    @Override
    protected void obterItemSelecionadoNaTabela(Fornecedor itemSelecionado) {
        fornencedor = itemSelecionado;
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
