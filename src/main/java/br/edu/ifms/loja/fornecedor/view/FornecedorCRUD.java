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
 * @author NVIDIA
 */
public class FornecedorCRUD extends GenericCRUD<Fornecedor> {

    private Fornecedor fornencedor;
    private FornecedorBO fornecedorBO;
    private FornecedorFormulario formularioFornecedor;

    public FornecedorCRUD(Frame parent, boolean modal) {
        super(parent, modal, Fornecedor.class, new String[]{"idFornecedor", "nomefantasia", "cnpj"});

        fornecedorBO = new FornecedorBO();
        carregarTabela();

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioFornecedor = new FornecedorFormulario();
        return formularioFornecedor;
    }

    @Override
    protected void camposParaObjeto() {
        fornencedor.setNomefantasia(formularioFornecedor.getCampoNomeFantasia().getText());
        fornencedor.setRazaosocial(formularioFornecedor.getCampoRazaoSocial().getText());
        fornencedor.setCnpj(formularioFornecedor.getCampoCNPJ().getText());
        fornencedor.setTelefone(formularioFornecedor.getCampoTelefone().getText());
        fornencedor.setEmail(formularioFornecedor.getCampoEmail().getText());
        fornencedor.setCep(formularioFornecedor.getCampoCEP().getText());
        fornencedor.setEndereco(formularioFornecedor.getCampoEndereco().getText());
        fornencedor.setNumero(formularioFornecedor.getCampoNumero().getText());
        fornencedor.setCidade(formularioFornecedor.getComboBoxUfCidade().getSelectedCidade());

    }

    @Override
    protected void objetoParaCampos() {
        formularioFornecedor.getCampoNomeFantasia().setText(fornencedor.getNomefantasia());
        formularioFornecedor.getCampoRazaoSocial().setText(fornencedor.getRazaosocial());
        formularioFornecedor.getCampoCNPJ().setText(fornencedor.getCnpj());
        formularioFornecedor.getCampoTelefone().setText(fornencedor.getTelefone());
        formularioFornecedor.getCampoEmail().setText(fornencedor.getEmail());
        formularioFornecedor.getCampoCEP().setText(fornencedor.getCep());
        formularioFornecedor.getCampoEndereco().setText(fornencedor.getEndereco());
        formularioFornecedor.getCampoNumero().setText(fornencedor.getNumero());
        formularioFornecedor.getComboBoxUfCidade().setSelectedCidade(fornencedor.getCidade());

    }

    @Override
    protected void salvar() {
        fornecedorBO.inserir(fornencedor);
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
        fornecedorBO.remover(fornencedor);
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
        return fornecedorBO.buscarFornecedorPorNomeFantasia(param);
    }

}
