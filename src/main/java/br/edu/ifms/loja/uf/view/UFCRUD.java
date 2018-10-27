/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.uf.bo.UFBO;
import br.edu.ifms.loja.uf.datamodel.UF;
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
public class UFCRUD extends GenericCRUD<UF> {

    private UFBO ufbo;
    private UF uf;
    private UFFormulario formularioUF;

    public UFCRUD(Frame parent, boolean modal) {
        super(parent, modal, UF.class, new String[]{ "nome", "sigla","icms"});
        try {
            ufbo = new UFBO();
            carregarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(UFCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioUF = new UFFormulario();
        return formularioUF;
    }

    @Override
    protected void camposParaObjeto() {
        uf.setNome(formularioUF.getCampoNome().getText());
        uf.setSigla(formularioUF.getCampoSigla().getText());
        uf.setIcms(Float.parseFloat(formularioUF.getCampoICMS().getText()));
    }

    @Override
    protected void objetoParaCampos() {

        formularioUF.getCampoNome().setText(uf.getNome());
        formularioUF.getCampoSigla().setText(uf.getSigla());
        formularioUF.getCampoICMS().setText(String.valueOf(uf.getIcms()));
    }

    @Override
    protected void salvar() {
        ufbo.inserir(uf);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        uf = new UF();
    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        ufbo.remover(uf);
    }

    @Override
    protected List buscar(String param) {
        return ufbo.buscarClientePorSiglaouNome(param);
    }

    @Override
    protected List<UF> carregarListaParaTabela() {
        return ufbo.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(UF itemSelecionado) {
        uf = itemSelecionado;
    }

}
