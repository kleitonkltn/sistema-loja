package br.edu.ifms.loja.produto.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.produto.bo.ProdutoBO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.awt.Frame;
import java.math.BigInteger;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

/**
 *
 * @author NVIDIA
 */
public class ProdutoCRUD extends GenericCRUD<Produto> {

    private Produto produto;
    private ProdutoFormulario produtoFormulario;
    private ProdutoBO produtoBO;

    public ProdutoCRUD(Frame parent, boolean modal) {
        super(parent, modal, Produto.class, new String[]{"descricao","valor","qtde","modelo"});

        try {
            produtoBO = new ProdutoBO();
            carregarTabela();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        produtoFormulario = new ProdutoFormulario();
        produtoFormulario.setVisible(true);
        return produtoFormulario;

    }

    @Override
    protected void camposParaObjeto() {

        produto.setDescricao(produtoFormulario.getCampoDescricao().getText());
        produto.setMarca(produtoFormulario.getCampoMarca().getText());
        produto.setModelo(produtoFormulario.getCampoModelo().getText());
        produto.setQtde(Integer.parseInt(produtoFormulario.getCampoQuantidade().getText()));
    }

    @Override
    protected void objetoParaCampos() {
        produtoFormulario.getCampoDescricao().setText(produto.getDescricao());
        produtoFormulario.getCampoMarca().setText(produto.getMarca());
        produtoFormulario.getCampoModelo().setText(produto.getModelo());
        produtoFormulario.getCampoQuantidade().setText(String.valueOf((produto.getQtde())));
    }

    @Override
    protected void salvar() {
        produtoBO.inserir(produto);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        produto = new Produto();
    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        produtoBO.remover(produto);
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Produto> carregarListaParaTabela() {
        return produtoBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Produto itemSelecionado) {
        this.produto = itemSelecionado;

    }

}
