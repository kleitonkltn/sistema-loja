/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.cidade.bo.CidadeBO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.uf.bo.UFBO;
import br.edu.ifms.loja.uf.datamodel.UF;

import java.awt.Frame;

import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author NVIDIA
 */
public class CidadeCRUD extends GenericCRUD<Cidade> {

    private Cidade cidade;
    private UFBO ufBO;
    private CidadeBO cidadeBO;
    private CidadeFormulario formularioCidade;

    public CidadeCRUD(Frame parent, boolean modal) {
        super(parent, modal, Cidade.class, new String[]{"idCidade", "nome", "uf.nome:UF"});
        cidadeBO = new CidadeBO();
        ufBO = new UFBO();
        carregarTabela();
        carregarComboBoxUF();

    }

    private void carregarComboBoxUF() {
        List<UF> ufs = ufBO.listarTodos();
        formularioCidade.carregarComboBoxUF(ufs);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioCidade = new CidadeFormulario();
        return formularioCidade;
    }

    @Override
    protected void camposParaObjeto() {
        cidade.setNome(formularioCidade.getCampoCidade().getText());
        cidade.setUf(formularioCidade.getUFSelecionada());
    }

    @Override
    protected void objetoParaCampos() {
        formularioCidade.getCampoCidade().setText(cidade.getNome());
        formularioCidade.setUFSelectionada(cidade.getUf());
    }

    @Override
    protected void salvar() {
        cidadeBO.inserir(cidade);

    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        cidade = new Cidade();

    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        cidadeBO.remover(cidade);
    }

    @Override
    protected List buscar(String param) {
        return null;
    }

    @Override
    protected List<Cidade> carregarListaParaTabela() {
        return cidadeBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Cidade itemSelecionado) {
        this.cidade = itemSelecionado;
    }

}
