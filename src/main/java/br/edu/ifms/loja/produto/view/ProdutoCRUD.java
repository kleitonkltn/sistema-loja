package br.edu.ifms.loja.produto.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.fornecedor.bo.FornecedorBO;
import br.edu.ifms.loja.produto.bo.ProdutoBO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.awt.Frame;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;

import java.util.List;

import javax.swing.JPanel;

/**
 *
 * @author NVIDIA
 */
public class ProdutoCRUD extends GenericCRUD<Produto> {

    private Produto produto;
    private ProdutoFormulario produtoFormulario;
    private ProdutoBO produtoBO;
    private FornecedorBO fornecedorBO;

    public ProdutoCRUD(Frame parent, boolean modal) {
        super(parent, modal, Produto.class, new String[]{"descricao", "valor", "qtde", "modelo"});

        produtoBO = new ProdutoBO();
        fornecedorBO = new FornecedorBO();
        carregarTabela();
        carregarComboBoxFornecedor();
    }

    public void carregarComboBoxFornecedor() {
        List<Fornecedor> listFornecedor = fornecedorBO.listarTodos();
        produtoFormulario.carregarFornecedor(listFornecedor);
    }

    @Override
    public void setSize(int width, int height
    ) {
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
        produto.setValor(Float.valueOf(produtoFormulario.getCampoValor().getText()));
        produto.setModelo(produtoFormulario.getCampoModelo().getText());
        produto.setQtde(Integer.parseInt(produtoFormulario.getCampoQuantidade().getText()));
        produto.setFornecedor(produtoFormulario.getFornecedor());
    }

    @Override
    protected void objetoParaCampos() {
        produtoFormulario.getCampoDescricao().setText(produto.getDescricao());
        produtoFormulario.getCampoMarca().setText(produto.getMarca());
        produtoFormulario.getCampoModelo().setText(produto.getModelo());
        produtoFormulario.getCampoValor().setText(String.valueOf(produto.getValor()));
        produtoFormulario.getCampoQuantidade().setText(String.valueOf((produto.getQtde())));
        produtoFormulario.getComboBoxFornecedor().setSelectedItem(produto.getFornecedor());
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
    protected List buscar(String param
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Produto> carregarListaParaTabela() {
        return produtoBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Produto itemSelecionado
    ) {
        this.produto = itemSelecionado;

    }

}
